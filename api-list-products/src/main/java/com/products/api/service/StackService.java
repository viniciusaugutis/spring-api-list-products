package com.products.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.products.api.model.Stack;
import com.products.api.repository.StackRepository;

@Service
public class StackService {
	
	@Autowired
	private StackRepository stackRepository;
	
	public Page<Stack> findAll(Pageable pageable) {
		return stackRepository.findAll(pageable);
	}

}
