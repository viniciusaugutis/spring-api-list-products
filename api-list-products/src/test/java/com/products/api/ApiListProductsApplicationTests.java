package com.products.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.products.api.model.Product;
import com.products.api.repository.ProductRepository;
import com.products.api.repository.filter.ProductFilter;
import com.products.api.repository.projection.ProductSummary;
import com.products.api.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiListProductsApplicationTests {

	@Autowired
	ProductService productService;

	@Autowired
	ProductRepository productRepository;

	@Test
	public void testFindProductByName() {
		Page<Product> pageProduct = productRepository.findByNameContainingIgnoreCase("Gubee Integrador",
				PageRequest.of(0, 10));
		assertEquals(1, pageProduct.getContent().stream().distinct().count());
	}
	
	@Test
	public void testFindProductByStack() {
		ProductFilter productFilter = new ProductFilter();
		List<Long> stacks = new ArrayList<Long>();
		stacks.add(3L);
		
		productFilter.setStack(stacks);
		
		Page<ProductSummary> pageObject = productService.filterProduct(productFilter,
				PageRequest.of(0, 10));
		assertEquals(2, pageObject.getTotalElements());
	}
	
	@Test
	public void testFindProductByMarket() {
		ProductFilter productFilter = new ProductFilter();
		List<Long> targetMarkets = new ArrayList<Long>();
		targetMarkets.add(3L);
		
		productFilter.setTargetMarket(targetMarkets);
		
		Page<ProductSummary> pageObject = productService.filterProduct(productFilter,
				PageRequest.of(0, 10));
		
		
		assertEquals(true, pageObject.getContent().get(0).getTargetMarket().contains("Lojista que não desejam possuir ecommerce"));
	}

}
