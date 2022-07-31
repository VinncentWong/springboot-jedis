package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableCaching
//@EnableRedisRepositories -> Enable Redis Repositories -> Used for Redis OM
public class Springbootstarter1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootstarter1Application.class, args);
	}

}
