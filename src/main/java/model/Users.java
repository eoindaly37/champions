package model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "users")
@Getter @Setter
class Users {

	private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
	private String name;
	private String email;
	private String slack;

	Users() {}

	Users(String name, String email, String slack) {
		this.name = name;
		this.email = email;
		this.slack = slack;
	}
}
