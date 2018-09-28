package com.products.api.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.products.api.repository.filter.ProductFilter;

public interface ProductRepositoryQuery {

	public Page<Object> filterProduct(ProductFilter productFilter, Pageable pageable);

}
