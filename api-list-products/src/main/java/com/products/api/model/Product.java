package com.products.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O nome do produto é um campo obrigatório")
	private String name;
	
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "product_market", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = {
				@JoinColumn(name = "market_id") })
	private List<Market> targetMarket;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "product_stack", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = {
				@JoinColumn(name = "stack_id") })
	private List<Market> stack;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<Market> getTargetMarket() {
		return targetMarket;
	}

	public void setTargetMarket(List<Market> targetMarket) {
		this.targetMarket = targetMarket;
	}

	public List<Market> getStack() {
		return stack;
	}

	public void setStack(List<Market> stack) {
		this.stack = stack;
	}

	public Product() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}