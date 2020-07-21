package converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import dto.ProductsDTO;
import model.Products;

@Component
public class ProductConverter {
	
	public ProductsDTO entityToDTO(Products product){
		
		ModelMapper mapper = new ModelMapper();
		ProductsDTO map = mapper.map(product, ProductsDTO.class);
		
		return map;
	}
	
	public List<ProductsDTO> entityToDTO(List<Products> product){
		return product.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
	}
	
	public Products dtoToEntity(ProductsDTO dto) {
		ModelMapper mapper = new ModelMapper();
		Products map = mapper.map(dto, Products.class);
		return map;
	}
	
	public List<Products> dtoToEntity(List<ProductsDTO> dto){
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
