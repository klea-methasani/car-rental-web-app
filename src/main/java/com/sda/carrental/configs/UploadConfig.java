package com.sda.carrental.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UploadConfig {
	@Value("${upload.directory}")
	private String uploadDirectory;

	public String getUploadDirectory() {
		return uploadDirectory;
	}
}
