package controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.LookForHelp;
import repo.LookForHelpRepository;

@RestController
class LookForHelpController {

	private final LookForHelpRepository repository;

	LookForHelpController(LookForHelpRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	@GetMapping("/lookforhelp")
	List<LookForHelp> all() {
		return repository.findAll();
	}

	@PostMapping("/lookforhelp")
	LookForHelp newEmployee(@RequestBody LookForHelp newEmployee) {
		return repository.save(newEmployee);
	}

	// Single item
	
	@GetMapping("/lookforhelp/{id}")
	LookForHelp one(@PathVariable Long id) {
		
		return repository.findById(id)
			.orElseThrow(() -> new UserNotFoundException(id));
	}

	@PutMapping("/lookforhelp/{id}")
	LookForHelp replaceEmployee(@RequestBody LookForHelp newEmployee, @PathVariable Long id) {
		
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

	@DeleteMapping("/lookforhelp/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}