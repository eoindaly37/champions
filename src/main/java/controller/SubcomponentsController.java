package controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Subcomponents;
import repo.SubcomponentsRepository;

@RestController
class SubcomponentsController {

	private final SubcomponentsRepository repository;

	SubcomponentsController(SubcomponentsRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	@GetMapping("/subcomponents")
	List<Subcomponents> all() {
		return repository.findAll();
	}

	@PostMapping("/subcomponents")
	Subcomponents newEmployee(@RequestBody Subcomponents newEmployee) {
		return repository.save(newEmployee);
	}

	// Single item
	
	@GetMapping("/subcomponents/{id}")
	Subcomponents one(@PathVariable Long id) {
		
		return repository.findById(id)
			.orElseThrow(() -> new UserNotFoundException(id));
	}

	@PutMapping("/subcomponents/{id}")
	Subcomponents replaceEmployee(@RequestBody Subcomponents newEmployee, @PathVariable Long id) {
		
		return repository.findById(id)
			.map(employee -> {
				employee.setProductid(newEmployee.getProductid());
				employee.setName(newEmployee.getName());
				employee.setNotes(newEmployee.getNotes());
				employee.setCode(newEmployee.getCode());
				employee.setJira(newEmployee.getJira());
				employee.setPlaybook(newEmployee.getPlaybook());
				employee.setToi(newEmployee.getToi());
				employee.setSlacksupport(newEmployee.getSlacksupport());
				employee.setSlackengineer(newEmployee.getSlackengineer());
				return repository.save(employee);
			})
			.orElseGet(() -> {
				newEmployee.setId(id);
				return repository.save(newEmployee);
			});
	}

	@DeleteMapping("/subcomponents/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}