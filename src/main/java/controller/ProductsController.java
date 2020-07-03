package controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Products;

@RestController
class ProductsController {

	private final ProductsRepository repository;

	ProductsController(ProductsRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	@GetMapping("/products")
	List<Products> all() {
		return repository.findAll();
	}

	@PostMapping("/products")
	Products newEmployee(@RequestBody Products newEmployee) {
		return repository.save(newEmployee);
	}

	// Single item
	
	@GetMapping("/products/{id}")
	Products one(@PathVariable Long id) {
		
		return repository.findById(id)
			.orElseThrow(() -> new UserNotFoundException(id));
	}

	@PutMapping("/products/{id}")
	Products replaceEmployee(@RequestBody Products newEmployee, @PathVariable Long id) {
		
		return repository.findById(id)
			.map(employee -> {
				employee.setName(newEmployee.getName());
				employee.setLead(newEmployee.getLead());
				employee.setDomain(newEmployee.getDomain());
				return repository.save(employee);
			})
			.orElseGet(() -> {
				newEmployee.setId(id);
				return repository.save(newEmployee);
			});
	}

	@DeleteMapping("/products/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}