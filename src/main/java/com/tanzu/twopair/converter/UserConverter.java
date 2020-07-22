package com.tanzu.twopair.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.tanzu.twopair.dto.UsersDTO;
import com.tanzu.twopair.model.Users;

@Component
public class UserConverter {
	
	public UsersDTO entityToDTO(Users user){
		
		ModelMapper mapper = new ModelMapper();
		return mapper.map(user, UsersDTO.class);
	}
	
	public List<UsersDTO> entityToDTO(List<Users> user){
		return user.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
	}
	
	public Users dtoToEntity(UsersDTO dto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(dto, Users.class);
	}
	
	public List<Users> dtoToEntity(List<UsersDTO> dto){
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
