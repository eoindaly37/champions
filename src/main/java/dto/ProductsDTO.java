package dto;

import lombok.Data;
import dto.DomainsDTO;
import dto.UsersDTO;

@Data
public class ProductsDTO {

	private Long id;
	private String name;
	private UsersDTO lead;
	private DomainsDTO domain;
}
