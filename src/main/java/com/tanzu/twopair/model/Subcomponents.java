package com.tanzu.twopair.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Data
@Entity
@Table(name = "subcomponents")
@Getter @Setter
public class Subcomponents {

	private @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id")Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productid", referencedColumnName = "id")
	private Products productid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "notes")
	private String notes;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "jira")
	private String jira;
	
	@Column(name = "playbook")
	private String playbook;
	
	@Column(name = "toi")
	private String toi;
	
	@Column(name = "slacksupport")
	private String slacksupport;
	
	@Column(name = "slackengineer")
	private String slackengineer;
	
	Subcomponents() {}
	
	Subcomponents(Products productid, String name, String notes, String code, String jira, String playbook, String toi, String slacksupport, String slackengineer){
		
		this.productid = productid;
		this.name = name;
		this.notes = notes;
		this.code = code;
		this.jira = jira;
		this.playbook = playbook;
		this.toi = toi;
		this.slacksupport = slacksupport;
		this.slackengineer = slackengineer;
	}

	
}
