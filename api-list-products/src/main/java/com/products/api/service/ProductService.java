package com.products.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.products.api.model.Product;
import com.products.api.repository.ProductRepository;
import com.products.api.repository.filter.ProductFilter;
import com.products.api.repository.projection.ProductSummary;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Page<ProductSummary> filterProduct(ProductFilter productFilter, Pageable pageable) {
		return productRepository.filterProduct(productFilter, pageable);
	}

	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	public Product create(Product product) {
		return productRepository.save(product);
	}

}
