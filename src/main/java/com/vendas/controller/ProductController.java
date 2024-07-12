package com.vendas.controller;

import com.vendas.model.Product;
import com.vendas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductService service;

	@PostMapping
	public ResponseEntity<Product> register(@RequestBody Product product) {
		product = service.register(product);
		return ResponseEntity.ok(product);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Product>> getAllProducts() {
		return ResponseEntity.ok(service.findAll());
	}
}
