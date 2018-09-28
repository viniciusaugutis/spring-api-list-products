package com.products.api.repository.filter;

import java.util.List;

public class ProductFilter {

	private String name;

	private List<Long> targetMarket;

	private List<Long> stack;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getTargetMarket() {
		return targetMarket;
	}

	public void setTargetMarket(List<Long> targetMarket) {
		this.targetMarket = targetMarket;
	}

	public List<Long> getStack() {
		return stack;
	}

	public void setStack(List<Long> stack) {
		this.stack = stack;
	}

}
