package com.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConfig {
    /*
        1. Create Jedis Connection through JedisConnectionFactory class
        2. To access redis, useRedisTemplate
     */

    
}
