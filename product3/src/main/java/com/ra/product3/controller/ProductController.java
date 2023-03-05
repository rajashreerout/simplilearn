package com.ra.product3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ra.product3.entity.Product;
import com.ra.product3.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/v1/api")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping("/create-product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	@PutMapping("/update-product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
		return productService.updateProduct(id, productDetails);
	}

}
