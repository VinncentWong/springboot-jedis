package com.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

<<<<<<< HEAD
    @GetMapping("/home")
    public String helloWorld2() {
    	return "Hello Home";
    }
    
    @GetMapping("/getproduct")
    public ArrayList<Product> getProduct(){
    	return productService.getProduct();
    }
    
    @PostMapping("/addproduct")
    public ArrayList<Product> addProduct(@RequestBody Product product){
    	return productService.addProduct(product);
    }
=======
	@GetMapping("/home")
	public String helloWorld2() {
		return "Hello Home";
	}

	@GetMapping("/getproduct")
	public ArrayList<Product> getProduct(){
		return productService.getProduct();
	}
>>>>>>> 177741455d80b46bf2431a2955b1af14fb7d294f
}
