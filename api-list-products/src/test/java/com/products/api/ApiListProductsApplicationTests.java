package com.products.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.products.api.model.Product;
import com.products.api.repository.ProductRepository;
import com.products.api.repository.filter.ProductFilter;
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
		
		Page<Object> pageObject = productService.filterProduct(productFilter,
				PageRequest.of(0, 10));
		assertEquals(2, pageObject.getTotalElements());
	}
	
	@Test
	public void testFindProductByMarket() {
		ProductFilter productFilter = new ProductFilter();
		List<Long> targetMarkets = new ArrayList<Long>();
		targetMarkets.add(3L);
		
		productFilter.setStack(targetMarkets);
		
		Page<Object> pageObject = productService.filterProduct(productFilter,
				PageRequest.of(0, 10));
		assertEquals(2, pageObject.getTotalElements());
	}

	/*
	@Test
	public void testProductServiceMockito() {
		Optional<Product> product = Optional.of(new Product(1L, "Produto 1", "Descrição do produto 1"));
		when(productService.findById(1L)).thenReturn(product);
		assertEquals(product.get(), productService.findById(1L).get());
	}*/

}
