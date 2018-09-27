package com.products.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.api.model.Stack;

public interface StackRepository extends JpaRepository<Stack, Long> {

}
