package com.products.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.api.model.Market;
import com.products.api.service.MarketService;


@RestController
@RequestMapping("/target_markets")
public class MarketResource {

	@Autowired
	private MarketService marketService;

	@GetMapping
	public Page<Market> findAll(Pageable pageable) {
		return marketService.findAll(pageable);
	}
}
