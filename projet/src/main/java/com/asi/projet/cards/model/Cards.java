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
	
}
