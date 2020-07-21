package controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import service.DomainService;
import dto.DomainsDTO;

@RestController
class DomainsController {

	private DomainService service;

	DomainsController(DomainService service) {
		this.service = service;
	}

	// Aggregate root

	@GetMapping("/domains")
	List<DomainsDTO> all() {
		List<DomainsDTO> dtos = service.all();
		return dtos;
	}

	@PostMapping("/domains")
	DomainsDTO newEmployee(@RequestBody DomainsDTO dto) {
		DomainsDTO saved = service.newDomain(dto);
		return saved;
	}

	// Single item
	
	@GetMapping("/domains/{id}")
	DomainsDTO one(@PathVariable Long id) {
		DomainsDTO dto = service.single(id);
		return dto;
	}

	@PutMapping("/domains/{id}")
	DomainsDTO replaceEmployee(@RequestBody DomainsDTO dto, @PathVariable Long id) {
		DomainsDTO replaced = service.replaceDomain(dto, id);
		return replaced;
	}

	@DeleteMapping("/domains/{id}")
	void deleteEmployee(@PathVariable Long id) {
		service.deleteDomain(id);
	}
}