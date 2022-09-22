package com.khai.imageUpload.serviceImpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khai.imageUpload.model.ImageDatabase;
import com.khai.imageUpload.repository.ImageRepository;
import com.khai.imageUpload.service.ImageService;
import com.khai.imageUpload.utils.ImageUtils;

@Service
public class ImageServiceImpl implements ImageService {

	Logger log = LoggerFactory.getLogger(ImageServiceImpl.class);
	
	@Autowired
	ImageRepository imageRepository;
	
	@Override
	public String saveImage(MultipartFile file) {
		try {
			ImageDatabase image = ImageDatabase.builder()
					.name(file.getOriginalFilename())
	                .type(file.getContentType())
	                .image(ImageUtils.compressImage(file.getBytes()))
	                .build();
			return imageRepository.save(image).getName();
		}catch(Exception e) {
			log.error(e.getMessage());
		}
		return null;

		
	}

	@Override
	public byte[] getImageById(Long image_id) {
	    Optional<ImageDatabase> dbImageData = imageRepository.findById(image_id);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImage());
        return images;
	}

}
