package com.khai.imageUpload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.khai.imageUpload.service.ImageService;

@RestController
@RequestMapping("api/v1/images")
public class ImageController {

	@Autowired
	ImageService imageService;
	
	@PostMapping
	public ResponseEntity<String> saveImage(
			@RequestParam("image") MultipartFile file){
		String imageName = imageService.saveImage(file);
		return new ResponseEntity<>("Save successfully image " + imageName,HttpStatus.CREATED);
	}
	
	@GetMapping("/{image_id}")
	public ResponseEntity<?> getImageById(
			@PathVariable(value = "image_id") Long image_id){
		byte[] image = imageService.getImageById(image_id);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(image);
	}
}
