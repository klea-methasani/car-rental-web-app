package com.sda.carrental.service.serviceImpl;

import com.sda.carrental.configs.UploadConfig;
import com.sda.carrental.models.ModelMapperUtils;
import com.sda.carrental.models.Image;
import com.sda.carrental.repository.ImageRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class ImageService {
	@Autowired
	UploadConfig uploadConfig;
	@Autowired
	ImageRepo imageRepo;

	public Image uploadImage (MultipartFile file) {
		String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
		String originalFileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
		String uniqueFileName = System.currentTimeMillis() + "_" + generateRandomFileName() + "." + fileExtension;

		File uploadDir = new File(uploadConfig.getUploadDirectory());
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		try {
			Path filePath = Path.of(uploadConfig.getUploadDirectory(), uniqueFileName);
			Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			System.out.println("e " + e);
			throw new RuntimeException();
		}

		Image image = new Image();
		image.setFileName(uniqueFileName);
		image.setOriginalFileName(originalFileName);
		String baseUrl = generateImageAbsolutePath();
		image.setUrl(baseUrl);
		imageRepo.save(image);
		return ModelMapperUtils.map(image, Image.class);
	}

	public String generateImageAbsolutePath() {
		return ServletUriComponentsBuilder.fromCurrentContextPath()
						.path("/images/")
						.toUriString();
	}

	public Image getImageById(String imageId) {
		return imageRepo.findById(Long.valueOf(imageId)).orElseThrow(EntityNotFoundException::new);
	}

	private String generateRandomFileName () {
		return RandomStringUtils.randomAlphanumeric(10);
	}
}
