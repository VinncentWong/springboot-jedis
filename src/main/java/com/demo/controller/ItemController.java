package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    @GetMapping("/home")
    public String helloWorld21() {
    	return "Hello Home";
    }
    
    @GetMapping("/getproduct")
    public Iterable<Product> getProduct(){
    	return productService.getProduct();
    }
    
    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product){
    	return productService.addProduct(product);
    }
    
    @GetMapping("/getform")
    public String greeting(@ModelAttribute("name") String name) {
    	return "Hello" + name;
    }
}
