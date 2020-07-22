package com.tanzu.twopair.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.tanzu.twopair.dto.SubcomponentsDTO;
import com.tanzu.twopair.model.Subcomponents;

@Component
public class SubcomponentConverter {
	
	public SubcomponentsDTO entityToDTO(Subcomponents subcomponent){
		
		ModelMapper mapper = new ModelMapper();
		return mapper.map(subcomponent, SubcomponentsDTO.class);
	}
	
	public List<SubcomponentsDTO> entityToDTO(List<Subcomponents> subcomponent){
		return subcomponent.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
	}
	
	public Subcomponents dtoToEntity(SubcomponentsDTO dto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(dto, Subcomponents.class);
	}
	
	public List<Subcomponents> dtoToEntity(List<SubcomponentsDTO> dto){
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
