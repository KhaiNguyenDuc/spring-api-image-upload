package com.khai.imageUpload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khai.imageUpload.model.ImageDatabase;

@Repository
public interface ImageRepository extends JpaRepository<ImageDatabase, Long> {

}
