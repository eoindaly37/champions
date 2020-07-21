package service;

import java.util.List;

import org.springframework.stereotype.Service;

import converter.ProductConverter;
import dto.ProductsDTO;
import model.Products;
import repo.ProductsRepository;

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
		List<ProductsDTO> dtos = converter.entityToDTO(entities);
		return dtos;
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
		ProductsDTO dto = converter.entityToDTO(product);
		return dto;
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
