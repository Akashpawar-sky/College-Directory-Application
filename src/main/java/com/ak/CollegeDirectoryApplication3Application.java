package com.ak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ak.*")
public class CollegeDirectoryApplication3Application {

	public static void main(String[] args) {
		SpringApplication.run(CollegeDirectoryApplication3Application.class, args);
	}

}
