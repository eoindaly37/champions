package model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "users")
@Getter @Setter
class Users {

	private @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id") Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "slack")
	private String slack;

	@OneToOne(mappedBy = "users")
	private Products product;
	
	Users() {}

	Users(String name, String email, String slack) {
		this.name = name;
		this.email = email;
		this.slack = slack;
	}
}
