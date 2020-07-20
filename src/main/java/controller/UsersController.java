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
import repo.UsersRepository;
import dto.UsersDTO;
import converter.UserConverter;

@RestController
class UsersController {

	private final UsersRepository repository;
	private UserConverter converter;

	UsersController(UsersRepository repository, UserConverter converter) {
		this.repository = repository;
		this.converter = converter;
	}

	// Aggregate root

	@GetMapping("/users")
	List<UsersDTO> all() {
		List<Users> findAll = repository.findAll();
		return converter.entityToDTO(findAll);
	}

	@PostMapping("/users")
	UsersDTO newEmployee(@RequestBody UsersDTO dto) {
		Users user = converter.dtoToEntity(dto);
		user = repository.save(user);
		return converter.entityToDTO(user);
	}

	// Single item
	
	@GetMapping("/users/{id}")
	UsersDTO one(@PathVariable Long id) {
		
		Users orElse = repository.findById(id).orElse(null);
		return converter.entityToDTO(orElse);
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