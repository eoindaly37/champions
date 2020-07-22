package com.tanzu.twopair.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tanzu.twopair.dto.LookForHelpDTO;
import com.tanzu.twopair.service.LookForHelpService;

@RestController
class LookForHelpController {

	private LookForHelpService service;

	LookForHelpController(LookForHelpService service) {
		this.service = service;
	}

	// Aggregate root

	@GetMapping("/lookforhelp")
	List<LookForHelpDTO> all() {
		return service.all();
	}

	@PostMapping("/lookforhelp")
	LookForHelpDTO newEmployee(@RequestBody LookForHelpDTO dto) {
		return service.newLookForHelp(dto);
	}

	// Single item
	
	@GetMapping("/lookforhelp/{id}")
	LookForHelpDTO one(@PathVariable Long id) {
		return service.single(id);
	}

	@PutMapping("/lookforhelp/{id}")
	LookForHelpDTO replaceEmployee(@RequestBody LookForHelpDTO dto, @PathVariable Long id) {
		return service.replaceLookForHelp(dto, id);
	}

	@DeleteMapping("/lookforhelp/{id}")
	void deleteEmployee(@PathVariable Long id) {
		service.deleteLookForHelp(id);
	}
}