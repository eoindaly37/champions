package controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Users;

@RestController
class UsersController {

	private final UsersRepository repository;

	UsersController(UsersRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	@GetMapping("/users")
	List<Users> all() {
		return repository.findAll();
	}

	@PostMapping("/users")
	Users newEmployee(@RequestBody Users newEmployee) {
		return repository.save(newEmployee);
	}

	// Single item
	
	@GetMapping("/users/{id}")
	Users one(@PathVariable Long id) {
		
		return repository.findById(id)
			.orElseThrow(() -> new UserNotFoundException(id));
	}

	@PutMapping("/users/{id}")
	Users replaceEmployee(@RequestBody Users newEmployee, @PathVariable Long id) {
		
		return repository.findById(id)
			.map(employee -> {
				employee.setName(newEmployee.getName());
				employee.setEmail(newEmployee.getEmail());
				employee.setSlack(newEmployee.getSlack());
				return repository.save(employee);
			})
			.orElseGet(() -> {
				newEmployee.setId(id);
				return repository.save(newEmployee);
			});
	}

	@DeleteMapping("/users/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}