package controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Domains;

@RestController
class DomainsController {

	private final DomainsRepository repository;

	DomainsController(DomainsRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	@GetMapping("/domains")
	List<Domains> all() {
		return repository.findAll();
	}

	@PostMapping("/domains")
	Domains newEmployee(@RequestBody Domains newEmployee) {
		return repository.save(newEmployee);
	}

	// Single item
	
	@GetMapping("/domains/{id}")
	Domains one(@PathVariable Long id) {
		
		return repository.findById(id)
			.orElseThrow(() -> new UserNotFoundException(id));
	}

	@PutMapping("/domains/{id}")
	Domains replaceEmployee(@RequestBody Domains newEmployee, @PathVariable Long id) {
		
		return repository.findById(id)
			.map(employee -> {
				employee.setName(newEmployee.getName());
				return repository.save(employee);
			})
			.orElseGet(() -> {
				newEmployee.setId(id);
				return repository.save(newEmployee);
			});
	}

	@DeleteMapping("/domains/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}