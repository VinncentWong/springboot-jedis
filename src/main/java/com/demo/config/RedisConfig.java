package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
    /*
        1. Create Jedis Connection through JedisConnectionFactory class
        2. To access redis, useRedisTemplate
     */
    
    @Bean
    public RedisTemplate<String, Object> redisTemplate(){
    	/*
    	 	Instead of using JedisConnectionFactory or LettuceFactory, we can setup redis config
    	 	on application.properties using prefix spring.redis.config -> exp spring.redis.port, etc
    	 */
    	RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    	return redisTemplate;
    }
}
