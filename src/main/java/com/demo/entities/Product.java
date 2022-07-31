package com.demo.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Product implements Serializable{
    
    /**
	* 
	*/
	private static final long serialVersionUID = -7662389562377520228L;

	@Id
    private Long id;

    private String name;

    private Integer price;
}
