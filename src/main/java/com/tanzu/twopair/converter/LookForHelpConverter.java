package com.tanzu.twopair.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.tanzu.twopair.dto.LookForHelpDTO;
import com.tanzu.twopair.model.LookForHelp;

@Component
public class LookForHelpConverter {
	
	public LookForHelpDTO entityToDTO(LookForHelp entity){
		
		ModelMapper mapper = new ModelMapper();
		return mapper.map(entity, LookForHelpDTO.class);
	}
	
	public List<LookForHelpDTO> entityToDTO(List<LookForHelp> entity){
		return entity.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
	}
	
	public LookForHelp dtoToEntity(LookForHelpDTO dto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(dto, LookForHelp.class);
	}
	
	public List<LookForHelp> dtoToEntity(List<LookForHelpDTO> dto){
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
