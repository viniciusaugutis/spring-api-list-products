package com.products.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.products.api.model.Market;
import com.products.api.repository.MarketRepository;

@Service
public class MarketService {
	
	@Autowired
	private MarketRepository marketRepository;
	
	public Page<Market> findAll(Pageable pageable) {
		return marketRepository.findAll(pageable);
	}

}
