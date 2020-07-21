package controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import service.ProductService;
import dto.ProductsDTO;

@RestController
class ProductsController {

	private ProductService service;

	ProductsController(ProductService service) {
		this.service = service;
	}

	// Aggregate root

	@GetMapping("/products")
	List<ProductsDTO> all() {
		List<ProductsDTO> dtos = service.all();
		return dtos;
	}

	@PostMapping("/products")
	ProductsDTO newEmployee(@RequestBody ProductsDTO dto) {
		ProductsDTO saved = service.newProduct(dto);
		return saved;
	}

	// Single item
	
	@GetMapping("/products/{id}")
	ProductsDTO one(@PathVariable Long id) {
		ProductsDTO dto = service.single(id);
		return dto;
	}

	@PutMapping("/products/{id}")
	ProductsDTO replaceEmployee(@RequestBody ProductsDTO dto, @PathVariable Long id) {
		ProductsDTO replaced = service.replaceProduct(dto, id);
		return replaced;
	}

	@DeleteMapping("/products/{id}")
	void deleteEmployee(@PathVariable Long id) {
		service.deleteProduct(id);
	}
}