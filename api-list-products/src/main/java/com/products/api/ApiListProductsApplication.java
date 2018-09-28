package com.products.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.products.api.config.property.ProductApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(ProductApiProperty.class)
public class ApiListProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiListProductsApplication.class, args);
	}
}
