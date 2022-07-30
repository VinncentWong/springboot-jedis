package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Springbootstarter1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootstarter1Application.class, args);
	}

}
