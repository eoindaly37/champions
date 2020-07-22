package com.tanzu.twopair.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.tanzu.twopair.dto.ProductsDTO;
import com.tanzu.twopair.model.Products;

@Component
public class ProductConverter {
	
	public ProductsDTO entityToDTO(Products product){
		
		ModelMapper mapper = new ModelMapper();
		return mapper.map(product, ProductsDTO.class);
	}
	
	public List<ProductsDTO> entityToDTO(List<Products> product){
		return product.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
	}
	
	public Products dtoToEntity(ProductsDTO dto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(dto, Products.class);
	}
	
	public List<Products> dtoToEntity(List<ProductsDTO> dto){
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
