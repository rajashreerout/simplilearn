package com.ra.product3.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ra.product3.entity.Product;

public interface ProductService {
	
	public ResponseEntity<Product> createProduct(Product product);
	public List<Product> getAllProducts();
	public ResponseEntity<Product> getProductById(Long id);
	public ResponseEntity<Product> updateProduct(Long id, Product productDetails);

}
