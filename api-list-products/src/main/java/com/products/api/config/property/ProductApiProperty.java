package com.products.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("products")
public class ProductApiProperty {

	private String originPermited;

	public String getOriginPermited() {
		return originPermited;
	}

	public void setOriginPermited(String originPermited) {
		this.originPermited = originPermited;
	}

}
