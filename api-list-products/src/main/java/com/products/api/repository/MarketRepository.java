package com.products.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.api.model.Market;

public interface MarketRepository extends JpaRepository<Market, Long> {

}
