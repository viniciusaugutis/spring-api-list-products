package com.products.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.products.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
