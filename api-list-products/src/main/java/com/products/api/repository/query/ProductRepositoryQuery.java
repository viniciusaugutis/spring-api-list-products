package com.products.api.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.products.api.repository.filter.ProductFilter;
import com.products.api.repository.projection.ProductSummary;

public interface ProductRepositoryQuery {

	public Page<ProductSummary> filterProduct(ProductFilter productFilter, Pageable pageable);

}
