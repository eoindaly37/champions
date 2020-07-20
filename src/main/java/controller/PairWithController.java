package controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.PairWith;
import repo.PairWithRepository;

@RestController
class PairWithController {

	private final PairWithRepository repository;

	PairWithController(PairWithRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	@GetMapping("/pairwith")
	List<PairWith> all() {
		return repository.findAll();
	}

	@PostMapping("/pairwith")
	PairWith newEmployee(@RequestBody PairWith newEmployee) {
		return repository.save(newEmployee);
	}

	// Single item
	
	@GetMapping("/pairwith/{id}")
	PairWith one(@PathVariable Long id) {
		
		return repository.findById(id)
			.orElseThrow(() -> new UserNotFoundException(id));
	}

	@PutMapping("/pairwith/{id}")
	PairWith replaceEmployee(@RequestBody PairWith newEmployee, @PathVariable Long id) {
		
		return repository.findById(id)
			.map(employee -> {
				employee.setProductid(newEmployee.getProductid());
				employee.setUserid(newEmployee.getUserid());
				return repository.save(employee);
			})
			.orElseGet(() -> {
				newEmployee.setId(id);
				return repository.save(newEmployee);
			});
	}

	@DeleteMapping("/pairwith/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}