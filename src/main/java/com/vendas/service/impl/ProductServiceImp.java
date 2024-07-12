package com.vendas.service.impl;

import com.vendas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.model.Product;
import com.vendas.model.ProductRepository;
import com.vendas.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public Product register(Product product) {
		return repository.save(product);
	}

	@Override
	public Iterable<Product> findAll() {
		return repository.findAll();
	}

}
