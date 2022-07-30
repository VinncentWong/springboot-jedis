package com.demo.service;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.entities.Product;

@Service
public class ProductService{
	ArrayList<Product> dummyObject = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		var product1 = new Product();
		var product2 = new Product();
		var product3 = new Product();
		var product4 = new Product();
		var product5 = new Product();
		product1.setId(1L);
		product2.setId(2L);
		product3.setId(3L);
		product4.setId(4L);
		product5.setId(5L);
		product1.setName("Produk 1");
		product2.setName("Produk 2");
		product3.setName("Produk 3");
		product4.setName("Produk 4");
		product5.setName("Produk 5");
		product1.setPrice(10000);
		product2.setPrice(20000);
		product3.setPrice(30000);
		product4.setPrice(40000);
		product5.setPrice(50000);
		dummyObject.add(product1);
		dummyObject.add(product2);
		dummyObject.add(product3);
		dummyObject.add(product4);
		dummyObject.add(product5);
	}
	
	@Cacheable(value = "product")
	public ArrayList<Product> getProduct(){
		System.out.println("Calling get Product");
		try{Thread.sleep(5000);}catch(InterruptedException ex) {ex.printStackTrace();}
		return dummyObject;
	}
	
	@CacheEvict(value = "product", allEntries = true)
	public ArrayList<Product> addProduct(Product product){
		dummyObject.add(product);
		// When add product, the cache is still not updated. We can tell old cache to remove itself when a product is added
		// The old cache will be evicted and the new cache("product") will be get a new cache when call getProduct() again
		return dummyObject;
	}
}
