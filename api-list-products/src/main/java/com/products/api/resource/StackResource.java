package com.products.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.api.model.Stack;
import com.products.api.service.StackService;


@RestController
@RequestMapping("/stacks")
public class StackResource {

	@Autowired
	private StackService stackService;

	@GetMapping
	public Page<Stack> findAll(Pageable pageable) {
		return stackService.findAll(pageable);
	}
}
