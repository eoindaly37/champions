package service;

import java.util.List;

import org.springframework.stereotype.Service;

import converter.PairWithConverter;
import dto.PairWithDTO;
import model.PairWith;
import repo.PairWithRepository;

@Service
public class PairWithService {

	private final PairWithRepository repository;
	private PairWithConverter converter;
	
	PairWithService(PairWithRepository repository, PairWithConverter converter) {
		this.repository = repository;
		this.converter = converter;
	}
	
	//returns list of all users
	public List<PairWithDTO> all(){
		List<PairWith> entities = repository.findAll();
		List<PairWithDTO> dtos = converter.entityToDTO(entities);
		return dtos;
	}
	
	//adds a single user
	public PairWithDTO newPairWith(PairWithDTO dto) {
		PairWith user = converter.dtoToEntity(dto);
		user = repository.save(user);
		return converter.entityToDTO(user);
	}
	
	//gets a user by ID
	public PairWithDTO single(Long id) {
		PairWith user = repository.findById(id).orElse(null);
		PairWithDTO dto = converter.entityToDTO(user);
		return dto;
	}
	
	//replace user
	public PairWithDTO replacePairWith(PairWithDTO dto, Long id) {
		PairWith newuser = converter.dtoToEntity(dto);
		return repository.findById(id)
				.map(user -> {
					user.setId(newuser.getId());
					user.setProductid(newuser.getProductid());
					user.setUserid(newuser.getUserid());
					return converter.entityToDTO(repository.save(user));
				})
				.orElseGet(() -> {
					newuser.setId(id);
					return converter.entityToDTO(repository.save(newuser));
				});
	}
	
	//delete user
	public void deletePairWith(Long id) {
		repository.deleteById(id);
	}
	
	
	
	
	
	
}
