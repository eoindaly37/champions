package com.tanzu.twopair.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tanzu.twopair.converter.ProductConverter;
import com.tanzu.twopair.dto.ProductsDTO;
import com.tanzu.twopair.model.Products;
import com.tanzu.twopair.repo.ProductsRepository;

@Service
public class ProductService {

	private final ProductsRepository repository;
	private ProductConverter converter;
	
	ProductService(ProductsRepository repository, ProductConverter converter) {
		this.repository = repository;
		this.converter = converter;
	}
	
	//returns list of all products
	public List<ProductsDTO> all(){
		List<Products> entities = repository.findAll();
		return converter.entityToDTO(entities);
	}
	
	//adds a single product
	public ProductsDTO newProduct(ProductsDTO dto) {
		Products product = converter.dtoToEntity(dto);
		product = repository.save(product);
		return converter.entityToDTO(product);
	}
	
	//gets a product by ID
	public ProductsDTO single(Long id) {
		Products product = repository.findById(id).orElse(null);
		return converter.entityToDTO(product);
	}
	
	//replace product
	public ProductsDTO replaceProduct(ProductsDTO dto, Long id) {
		Products newproduct = converter.dtoToEntity(dto);
		return repository.findById(id)
				.map(product -> {
					product.setName(newproduct.getName());
					product.setLead(newproduct.getLead());
					product.setDomain(newproduct.getDomain());
					return converter.entityToDTO(repository.save(product));
				})
				.orElseGet(() -> {
					newproduct.setId(id);
					return converter.entityToDTO(repository.save(newproduct));
				});
	}
	
	//delete product
	public void deleteProduct(Long id) {
		repository.deleteById(id);
	}
}
