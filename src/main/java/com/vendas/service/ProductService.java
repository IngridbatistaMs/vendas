package com.vendas.service;

import com.vendas.model.Product;

import java.util.List;

public interface ProductService {

	Product register(Product product);

	Iterable<Product> findAll();
}
