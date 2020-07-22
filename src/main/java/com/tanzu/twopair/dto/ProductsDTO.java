package com.tanzu.twopair.dto;

import com.tanzu.twopair.dto.DomainsDTO;
import com.tanzu.twopair.dto.UsersDTO;

import lombok.Data;

@Data
public class ProductsDTO {

	private Long id;
	private String name;
	private UsersDTO lead;
	private DomainsDTO domain;
}
