package com.tanzu.twopair.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.tanzu.twopair.dto.DomainsDTO;
import com.tanzu.twopair.model.Domains;

@Component
public class DomainConverter {
	
	public DomainsDTO entityToDTO(Domains domain){
		
		ModelMapper mapper = new ModelMapper();
		return mapper.map(domain, DomainsDTO.class);
	}
	
	public List<DomainsDTO> entityToDTO(List<Domains> domain){
		return domain.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
	}
	
	public Domains dtoToEntity(DomainsDTO dto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(dto, Domains.class);
	}
	
	public List<Domains> dtoToEntity(List<DomainsDTO> dto){
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
