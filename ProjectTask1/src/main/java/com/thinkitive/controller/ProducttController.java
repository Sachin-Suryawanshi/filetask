package com.thinkitive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.entity.Product;
import com.thinkitive.repository.ProductRepository;
import com.thinkitive.serviceimpl.ProductServiceImpl;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ProducttController {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductServiceImpl productService;

	@GetMapping(value = "/getallproducts")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@PutMapping(value = "/updateproduct")
	public String updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
		return "product updated Successfully";
	}

}
