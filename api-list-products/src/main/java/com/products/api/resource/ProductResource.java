package com.products.api.resource;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.api.model.Product;
import com.products.api.repository.filter.ProductFilter;
import com.products.api.repository.projection.ProductSummary;
import com.products.api.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@GetMapping
	public Page<ProductSummary> findAll(ProductFilter productFilter, Pageable pageable) {
		return productService.filterProduct(productFilter, pageable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Optional<Product> product = productService.findById(id);
		if (product.isPresent())
			return ResponseEntity.ok(product.get());
		else
			return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(product));
	}

}
