package com.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Product;
import com.demo.service.ProductService;

@RestController
public class ItemController {
	
	private final ProductService productService;
	
	@Autowired
	public ItemController(ProductService productService) {
		this.productService = productService;
	}
    
	@GetMapping("/")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/home")
	public String helloWorld2() {
		return "Hello Home";
	}

	@GetMapping("/getproduct")
	public ArrayList<Product> getProduct(){
		return productService.getProduct();
	}
}
