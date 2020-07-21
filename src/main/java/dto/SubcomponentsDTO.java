package dto;

import lombok.Data;

@Data
public class SubcomponentsDTO {
	private Long id;
	private ProductsDTO productid;
	private String name;
	private String notes;
	private String code;
	private String jira;
	private String playbook;
	private String toi;
	private String slacksupport;
	private String slackengineer;
}
