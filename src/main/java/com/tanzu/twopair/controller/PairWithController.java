package com.tanzu.twopair.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tanzu.twopair.dto.PairWithDTO;
import com.tanzu.twopair.service.PairWithService;

@RestController
class PairWithController {

	private PairWithService service;

	PairWithController(PairWithService service) {
		this.service = service;
	}

	// Aggregate root

	@GetMapping("/pairwith")
	List<PairWithDTO> all() {
		return service.all();
	}

	@PostMapping("/pairwith")
	PairWithDTO newEmployee(@RequestBody PairWithDTO dto) {
		return service.newPairWith(dto);
	}

	// Single item
	
	@GetMapping("/pairwith/{id}")
	PairWithDTO one(@PathVariable Long id) {
		return service.single(id);
	}

	@PutMapping("/pairwith/{id}")
	PairWithDTO replaceEmployee(@RequestBody PairWithDTO dto, @PathVariable Long id) {
		return service.replacePairWith(dto, id);
	}

	@DeleteMapping("/pairwith/{id}")
	void deleteEmployee(@PathVariable Long id) {
		service.deletePairWith(id);
	}
}