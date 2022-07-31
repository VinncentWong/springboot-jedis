package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
    /*
        1. Create Jedis Connection through JedisConnectionFactory class
        2. To access redis, useRedisTemplate
     */
    
	@Bean
	public LettuceConnectionFactory lettuceConnection() {
		var configuration = new RedisStandaloneConfiguration("localhost", 6379);
		var lettuceConnection = new LettuceConnectionFactory(configuration);
		return lettuceConnection;
	}
    @Bean
    public RedisTemplate<String, Object> redisTemplate(){
    	RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    	redisTemplate.setConnectionFactory(lettuceConnection());
    	return redisTemplate;
    }
}
