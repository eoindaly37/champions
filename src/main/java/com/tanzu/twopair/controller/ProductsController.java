package com.tanzu.twopair.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tanzu.twopair.dto.ProductsDTO;
import com.tanzu.twopair.service.ProductService;

@RestController
class ProductsController {

	private ProductService service;

	ProductsController(ProductService service) {
		this.service = service;
	}

	// Aggregate root

	@GetMapping("/products")
	List<ProductsDTO> all() {
		return service.all();
	}

	@PostMapping("/products")
	ProductsDTO newEmployee(@RequestBody ProductsDTO dto) {
		return service.newProduct(dto);
	}

	// Single item
	
	@GetMapping("/products/{id}")
	ProductsDTO one(@PathVariable Long id) {
		return service.single(id);
	}

	@PutMapping("/products/{id}")
	ProductsDTO replaceEmployee(@RequestBody ProductsDTO dto, @PathVariable Long id) {
		return service.replaceProduct(dto, id);
	}

	@DeleteMapping("/products/{id}")
	void deleteEmployee(@PathVariable Long id) {
		service.deleteProduct(id);
	}
}