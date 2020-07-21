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
		Users newuser = converter.dtoToEntity(dto);
		return repository.findById(id)
				.map(user -> {
					user.setName(newuser.getName());
					user.setEmail(newuser.getEmail());
					user.setSlack(newuser.getSlack());
					return converter.entityToDTO(repository.save(user));
				})
				.orElseGet(() -> {
					newuser.setId(id);
					return converter.entityToDTO(repository.save(newuser));
				});
	}
	
	//delete user
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}
	
	
	
	
	
	
}
