package com.tanzu.twopair.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tanzu.twopair.dto.SubcomponentsDTO;
import com.tanzu.twopair.service.SubcomponentService;

@RestController
class SubcomponentsController {

	private SubcomponentService service;

	SubcomponentsController(SubcomponentService service) {
		this.service = service;
	}

	// Aggregate root

	@GetMapping("/subcomponents")
	List<SubcomponentsDTO> all() {
		return service.all();
	}

	@PostMapping("/subcomponents")
	SubcomponentsDTO newEmployee(@RequestBody SubcomponentsDTO dto) {
		return service.newSubcomponent(dto);
	}

	// Single item
	
	@GetMapping("/subcomponents/{id}")
	SubcomponentsDTO one(@PathVariable Long id) {
		return service.single(id);
	}

	@PutMapping("/subcomponents/{id}")
	SubcomponentsDTO replaceEmployee(@RequestBody SubcomponentsDTO dto, @PathVariable Long id) {
		return service.replaceSubcomponent(dto, id);
	}

	@DeleteMapping("/subcomponents/{id}")
	void deleteEmployee(@PathVariable Long id) {
		service.deleteSubcomponent(id);
	}
}