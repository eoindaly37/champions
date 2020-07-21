package controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import service.LookForHelpService;
import dto.LookForHelpDTO;

@RestController
class LookForHelpController {

	private LookForHelpService service;

	LookForHelpController(LookForHelpService service) {
		this.service = service;
	}

	// Aggregate root

	@GetMapping("/lookforhelp")
	List<LookForHelpDTO> all() {
		List<LookForHelpDTO> dtos = service.all();
		return dtos;
	}

	@PostMapping("/lookforhelp")
	LookForHelpDTO newEmployee(@RequestBody LookForHelpDTO dto) {
		LookForHelpDTO saved = service.newLookForHelp(dto);
		return saved;
	}

	// Single item
	
	@GetMapping("/lookforhelp/{id}")
	LookForHelpDTO one(@PathVariable Long id) {
		LookForHelpDTO dto = service.single(id);
		return dto;
	}

	@PutMapping("/lookforhelp/{id}")
	LookForHelpDTO replaceEmployee(@RequestBody LookForHelpDTO dto, @PathVariable Long id) {
		LookForHelpDTO replaced = service.replaceLookForHelp(dto, id);
		return replaced;
	}

	@DeleteMapping("/lookforhelp/{id}")
	void deleteEmployee(@PathVariable Long id) {
		service.deleteLookForHelp(id);
	}
}