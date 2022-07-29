package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    
    @GetMapping("/")
    public String helloWorld() {
    	return "Hello World";
    }

    @GetMapping("/home")
    public String helloWorld2() {
    	return "Hello Home";
    }
}
