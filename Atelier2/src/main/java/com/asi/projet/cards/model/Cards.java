package com.asi.projet.cards.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cards {

	@Id
	@GeneratedValue
	private Integer id_Card;
	private Integer id_User;
	private Integer id_Template;
	
	public Cards() {
		
	}

	public Integer getId_Card() {
		return id_Card;
	}

	public void setId_Card(Integer id_Card) {
		this.id_Card = id_Card;
	}

	public Integer getId_User() {
		return id_User;
	}

	public void setId_User(Integer id_User) {
		this.id_User = id_User;
	}

	public Integer getId_Template() {
		return id_Template;
	}

	public void setId_Template(Integer id_Template) {
		this.id_Template = id_Template;
	}
	
}
