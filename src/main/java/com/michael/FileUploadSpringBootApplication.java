package com.michael;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.michael.storage.FileStorageService;

@SpringBootApplication
public class FileUploadSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadSpringBootApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(FileStorageService storageService) {
		return (args) -> {
			// delete previous result and create upload directory if not exists
            storageService.init();
		};
	}
}
