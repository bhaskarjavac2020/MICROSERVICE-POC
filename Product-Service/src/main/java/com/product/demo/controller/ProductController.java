package com.product.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.model.Product;
import com.product.demo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
	@Autowired
	private final ProductRepository productRepository;
	
	@RequestMapping("/getAll")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	@RequestMapping("/saveProduct")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody Product product) {
		productRepository.save(product);
	}
}
