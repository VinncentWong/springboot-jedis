package com.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash("Product")
public class Product {
    
    @Id
    private Long id;

    private String name;

    private Integer price;
}
