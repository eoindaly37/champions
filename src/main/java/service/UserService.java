package service;

import java.util.List;

import org.springframework.stereotype.Service;

import converter.UserConverter;
import dto.UsersDTO;
import model.Users;
import repo.UsersRepository;

@Service
public class UserService {

	private final UsersRepository repository;
	private UserConverter converter;
	
	UserService(UsersRepository repository, UserConverter converter) {
		this.repository = repository;
		this.converter = converter;
	}
	
	//returns list of all users
	public List<UsersDTO> all(){
		List<Users> entities = repository.findAll();
		List<UsersDTO> dtos = converter.entityToDTO(entities);
		return dtos;
	}
	
	//adds a single user
	public UsersDTO newUser(UsersDTO dto) {
		Users user = converter.dtoToEntity(dto);
		user = repository.save(user);
		return converter.entityToDTO(user);
	}
	
	//gets a user by ID
	public UsersDTO single(Long id) {
		Users user = repository.findById(id).orElse(null);
		UsersDTO dto = converter.entityToDTO(user);
		return dto;
	}
	
	//replace user
	public UsersDTO replaceUser(UsersDTO dto, Long id) {
		Users user = converter.dtoToEntity(dto);
		return repository.findById(id)
				.map(employee -> {
					employee.setName(user.getName());
					employee.setEmail(user.getEmail());
					employee.setSlack(user.getSlack());
					return converter.entityToDTO(repository.save(employee));
				})
				.orElseGet(() -> {
					user.setId(id);
					return converter.entityToDTO(repository.save(user));
				});
	}
	
	//delete user
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}
	
	
	
	
	
	
}
