package com.ra.product3.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ra.product3.entity.Product;
import com.ra.product3.exception.ProductNotFoundException;
import com.ra.product3.repository.ProductRepository;
import com.ra.product3.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public ResponseEntity<Product> createProduct(Product product) {
		Product newProduct = productRepository.save(product);
		return ResponseEntity.ok(newProduct);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public ResponseEntity<Product> getProductById(Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found!"));
		return ResponseEntity.ok(product);
	}

	@Override
	public ResponseEntity<Product> updateProduct(Long id, Product productDetails) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found!"));
		
		product.setId(productDetails.getId());
		product.setName(productDetails.getName());
		product.setPrice(productDetails.getPrice());
		
		Product updatedProduct = productRepository.save(product);
		
		return ResponseEntity.ok(updatedProduct);
	}

}
