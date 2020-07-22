package com.tanzu.twopair.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tanzu.twopair.dto.DomainsDTO;
import com.tanzu.twopair.service.DomainService;

@RestController
class DomainsController {

	private DomainService service;

	DomainsController(DomainService service) {
		this.service = service;
	}

	// Aggregate root

	@GetMapping("/domains")
	List<DomainsDTO> all() {
		return service.all();
	}

	@PostMapping("/domains")
	DomainsDTO newEmployee(@RequestBody DomainsDTO dto) {
		return service.newDomain(dto);
	}

	// Single item
	
	@GetMapping("/domains/{id}")
	DomainsDTO one(@PathVariable Long id) {
		return service.single(id);
	}

	@PutMapping("/domains/{id}")
	DomainsDTO replaceEmployee(@RequestBody DomainsDTO dto, @PathVariable Long id) {
		return service.replaceDomain(dto, id);
	}

	@DeleteMapping("/domains/{id}")
	void deleteEmployee(@PathVariable Long id) {
		service.deleteDomain(id);
	}
}