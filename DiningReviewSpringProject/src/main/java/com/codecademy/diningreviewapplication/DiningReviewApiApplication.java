package com.codecademy.diningreviewapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.codecademy.diningreviewapplication.models")
public class DiningReviewApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiningReviewApiApplication.class, args);
	}

}
