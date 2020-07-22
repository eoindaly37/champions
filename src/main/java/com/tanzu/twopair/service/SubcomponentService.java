package com.tanzu.twopair.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tanzu.twopair.converter.SubcomponentConverter;
import com.tanzu.twopair.dto.SubcomponentsDTO;
import com.tanzu.twopair.model.Subcomponents;
import com.tanzu.twopair.repo.SubcomponentsRepository;

@Service
public class SubcomponentService {

	private final SubcomponentsRepository repository;
	private SubcomponentConverter converter;
	
	SubcomponentService(SubcomponentsRepository repository, SubcomponentConverter converter) {
		this.repository = repository;
		this.converter = converter;
	}
	
	//returns list of all subcomponents
	public List<SubcomponentsDTO> all(){
		List<Subcomponents> entities = repository.findAll();
		return converter.entityToDTO(entities);
	}
	
	//adds a single subcomponent
	public SubcomponentsDTO newSubcomponent(SubcomponentsDTO dto) {
		Subcomponents subcomponent = converter.dtoToEntity(dto);
		subcomponent = repository.save(subcomponent);
		return converter.entityToDTO(subcomponent);
	}
	
	//gets a subcomponent by ID
	public SubcomponentsDTO single(Long id) {
		Subcomponents subcomponent = repository.findById(id).orElse(null);
		return converter.entityToDTO(subcomponent);
	}
	
	//replace subcomponent
	public SubcomponentsDTO replaceSubcomponent(SubcomponentsDTO dto, Long id) {
		Subcomponents newsubcomponent = converter.dtoToEntity(dto);
		return repository.findById(id)
				.map(subcomponent -> {
					subcomponent.setProductid(newsubcomponent.getProductid());
					subcomponent.setName(newsubcomponent.getName());
					subcomponent.setNotes(newsubcomponent.getNotes());
					subcomponent.setCode(newsubcomponent.getCode());
					subcomponent.setJira(newsubcomponent.getJira());
					subcomponent.setPlaybook(newsubcomponent.getPlaybook());
					subcomponent.setToi(newsubcomponent.getToi());
					subcomponent.setSlacksupport(newsubcomponent.getSlacksupport());
					subcomponent.setSlackengineer(newsubcomponent.getSlackengineer());
					return converter.entityToDTO(repository.save(subcomponent));
				})
				.orElseGet(() -> {
					newsubcomponent.setId(id);
					return converter.entityToDTO(repository.save(newsubcomponent));
				});
	}
	
	//delete subcomponent
	public void deleteSubcomponent(Long id) {
		repository.deleteById(id);
	}
}
