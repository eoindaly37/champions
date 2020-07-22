package com.tanzu.twopair.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tanzu.twopair.converter.DomainConverter;
import com.tanzu.twopair.dto.DomainsDTO;
import com.tanzu.twopair.model.Domains;
import com.tanzu.twopair.repo.DomainsRepository;

@Service
public class DomainService {

	private final DomainsRepository repository;
	private DomainConverter converter;
	
	DomainService(DomainsRepository repository, DomainConverter converter) {
		this.repository = repository;
		this.converter = converter;
	}
	
	//returns list of all domains
	public List<DomainsDTO> all(){
		List<Domains> entities = repository.findAll();
		return converter.entityToDTO(entities);
	}
	
	//adds a single domain
	public DomainsDTO newDomain(DomainsDTO dto) {
		Domains domain = converter.dtoToEntity(dto);
		domain = repository.save(domain);
		return converter.entityToDTO(domain);
	}
	
	//gets a domain by ID
	public DomainsDTO single(Long id) {
		Domains domain = repository.findById(id).orElse(null);
		return converter.entityToDTO(domain);
	}
	
	//replace domain
	public DomainsDTO replaceDomain(DomainsDTO dto, Long id) {
		Domains newdomain = converter.dtoToEntity(dto);
		return repository.findById(id)
				.map(domain -> {
					domain.setName(newdomain.getName());
					return converter.entityToDTO(repository.save(domain));
				})
				.orElseGet(() -> {
					newdomain.setId(id);
					return converter.entityToDTO(repository.save(newdomain));
				});
	}
	
	//delete domain
	public void deleteDomain(Long id) {
		repository.deleteById(id);
	}
	
	
	
	
	
	
}
