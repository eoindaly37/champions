package com.tanzu.twopair.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tanzu.twopair.dto.UsersDTO;
import com.tanzu.twopair.service.UserService;

@RestController
class UsersController {

	private UserService service;

	UsersController(UserService service) {
		this.service = service;
	}

	// Aggregate root

	@GetMapping("/users")
	List<UsersDTO> all() {
		return service.all();
	}

	@PostMapping("/users")
	UsersDTO newEmployee(@RequestBody UsersDTO dto) {
		return service.newUser(dto);
	}

	// Single item
	
	@GetMapping("/users/{id}")
	UsersDTO one(@PathVariable Long id) {
		return service.single(id);
	}

	@PutMapping("/users/{id}")
	UsersDTO replaceEmployee(@RequestBody UsersDTO dto, @PathVariable Long id) {
		return service.replaceUser(dto, id);
	}

	@DeleteMapping("/users/{id}")
	void deleteEmployee(@PathVariable Long id) {
		service.deleteUser(id);
	}
}