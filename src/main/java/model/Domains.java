package model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "domains")
@Getter @Setter
class Domains {

	private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
	private String name;

	Domains() {}

	Domains(String name) {
		this.name = name;
	}
}
