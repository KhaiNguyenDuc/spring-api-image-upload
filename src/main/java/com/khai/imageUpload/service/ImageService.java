package com.khai.imageUpload.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

	String saveImage(MultipartFile file);

	byte[] getImageById(Long image_id);

}
