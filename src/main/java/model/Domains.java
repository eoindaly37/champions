package model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Data
@Entity
@Table(name = "domains")
@Getter @Setter
public class Domains {

	private @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id")Long id;
	
	@Column(name = "name")
	private String name;

	@OneToOne(mappedBy = "domain")
	private Products product;
	
	Domains() {}

	Domains(String name) {
		this.name = name;
	}
}
