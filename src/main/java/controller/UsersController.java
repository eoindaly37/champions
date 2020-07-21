package controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import service.UserService;
import dto.UsersDTO;

@RestController
class UsersController {

	private UserService service;

	UsersController(UserService service) {
		this.service = service;
	}

	// Aggregate root

	@GetMapping("/users")
	List<UsersDTO> all() {
		List<UsersDTO> dtos = service.all();
		return dtos;
	}

	@PostMapping("/users")
	UsersDTO newEmployee(@RequestBody UsersDTO dto) {
		UsersDTO saved = service.newUser(dto);
		return saved;
	}

	// Single item
	
	@GetMapping("/users/{id}")
	UsersDTO one(@PathVariable Long id) {
		UsersDTO dto = service.single(id);
		return dto;
	}

	@PutMapping("/users/{id}")
	UsersDTO replaceEmployee(@RequestBody UsersDTO dto, @PathVariable Long id) {
		UsersDTO replaced = service.replaceUser(dto, id);
		return replaced;
	}

	@DeleteMapping("/users/{id}")
	void deleteEmployee(@PathVariable Long id) {
		service.deleteUser(id);
	}
}