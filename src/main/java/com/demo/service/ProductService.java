package com.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.demo.entities.Product;
import com.demo.repository.ProductRepository;

@Transactional
@Service
public class ProductService{
//	ArrayList<Product> dummyObject = new ArrayList<>();
//	
//	@PostConstruct
//	public void init() {
//		var product1 = new Product();
//		var product2 = new Product();
//		var product3 = new Product();
//		var product4 = new Product();
//		var product5 = new Product();
//		product1.setId(1L);
//		product2.setId(2L);
//		product3.setId(3L);
//		product4.setId(4L);
//		product5.setId(5L);
//		product1.setName("Produk 1");
//		product2.setName("Produk 2");
//		product3.setName("Produk 3");
//		product4.setName("Produk 4");
//		product5.setName("Produk 5");
//		product1.setPrice(10000);
//		product2.setPrice(20000);
//		product3.setPrice(30000);
//		product4.setPrice(40000);
//		product5.setPrice(50000);
//		dummyObject.add(product1);
//		dummyObject.add(product2);
//		dummyObject.add(product3);
//		dummyObject.add(product4);
//		dummyObject.add(product5);
//	}
	
	private final ProductRepository repo;
	private final RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	public ProductService(ProductRepository repo, RedisTemplate<String,Object> redisTemplate) {
		this.repo = repo;
		this.redisTemplate = redisTemplate;
	}
	
	@Cacheable(value = "product")
	public Iterable<Product> getProduct(){
		System.out.println("Calling get Product");
		try{Thread.sleep(5000);}catch(InterruptedException ex) {ex.printStackTrace();}
		return repo.findAll();
	}
	
	@CacheEvict(value = "product", allEntries = true)
	public Product addProduct(Product product){
		var result = repo.save(product);
		redisTemplate.opsForValue().set("product", product);
		// Use opsForValue to get value operation -> method to perform operation to redis
		// When add product, the cache is still not updated. We can tell old cache to remove itself when a product is added
		// The old cache will be evicted and the new cache("product") will be get a new cache when call getProduct() again
		return result;
	}
}
