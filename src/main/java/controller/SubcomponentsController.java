package controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import service.SubcomponentService;
import dto.SubcomponentsDTO;

@RestController
class SubcomponentsController {

	private SubcomponentService service;

	SubcomponentsController(SubcomponentService service) {
		this.service = service;
	}

	// Aggregate root

	@GetMapping("/subcomponents")
	List<SubcomponentsDTO> all() {
		List<SubcomponentsDTO> dtos = service.all();
		return dtos;
	}

	@PostMapping("/subcomponents")
	SubcomponentsDTO newEmployee(@RequestBody SubcomponentsDTO dto) {
		SubcomponentsDTO saved = service.newSubcomponent(dto);
		return saved;
	}

	// Single item
	
	@GetMapping("/subcomponents/{id}")
	SubcomponentsDTO one(@PathVariable Long id) {
		SubcomponentsDTO dto = service.single(id);
		return dto;
	}

	@PutMapping("/subcomponents/{id}")
	SubcomponentsDTO replaceEmployee(@RequestBody SubcomponentsDTO dto, @PathVariable Long id) {
		SubcomponentsDTO replaced = service.replaceSubcomponent(dto, id);
		return replaced;
	}

	@DeleteMapping("/subcomponents/{id}")
	void deleteEmployee(@PathVariable Long id) {
		service.deleteSubcomponent(id);
	}
}