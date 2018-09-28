package com.products.api.repository.projection;

import java.util.List;
import java.util.stream.Collectors;

import com.products.api.model.Product;

public class ProductSummary {

	private String name;

	private String description;

	private List<String> targetMarket;

	private List<String> stack;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getTargetMarket() {
		return targetMarket;
	}

	public void setTargetMarket(List<String> targetMarket) {
		this.targetMarket = targetMarket;
	}

	public List<String> getStack() {
		return stack;
	}

	public void setStack(List<String> stack) {
		this.stack = stack;
	}

	public ProductSummary(Product product) {
		this.name = product.getName();
		this.description = product.getDescription();
		this.targetMarket = product.getTargetMarket().stream().map(m -> m.getName()).collect(Collectors.toList());
		this.stack = product.getStack().stream().map(m -> m.getName()).collect(Collectors.toList());
	}
}
