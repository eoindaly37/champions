package controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import service.PairWithService;
import dto.PairWithDTO;

@RestController
class PairWithController {

	private PairWithService service;

	PairWithController(PairWithService service) {
		this.service = service;
	}

	// Aggregate root

	@GetMapping("/pairwith")
	List<PairWithDTO> all() {
		List<PairWithDTO> dtos = service.all();
		return dtos;
	}

	@PostMapping("/pairwith")
	PairWithDTO newEmployee(@RequestBody PairWithDTO dto) {
		PairWithDTO saved = service.newPairWith(dto);
		return saved;
	}

	// Single item
	
	@GetMapping("/pairwith/{id}")
	PairWithDTO one(@PathVariable Long id) {
		PairWithDTO dto = service.single(id);
		return dto;
	}

	@PutMapping("/pairwith/{id}")
	PairWithDTO replaceEmployee(@RequestBody PairWithDTO dto, @PathVariable Long id) {
		PairWithDTO replaced = service.replacePairWith(dto, id);
		return replaced;
	}

	@DeleteMapping("/pairwith/{id}")
	void deleteEmployee(@PathVariable Long id) {
		service.deletePairWith(id);
	}
}