package com.vendas.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany
	@JoinTable(name = "cart_products", joinColumns =
			{@JoinColumn(name = "cart_id")}, inverseJoinColumns = {@JoinColumn(name = "productId")}
	)
	private List<Product> products = new ArrayList<>();

	@Transient
	private Double totalValue;

	@Column
	private boolean closed = false;
	
	public Cart() {
	}

	public Cart(Long id, List<Product> products, boolean closed) {
		this.id = id;
		this.products = products;
		this.closed = closed;
		calculateTotalValue();
	}

	public void calculateTotalValue(){
		this.totalValue = products.stream()
				.mapToDouble(Product::getValue)
				.sum();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}
}
