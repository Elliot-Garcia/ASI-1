package com.asi.projet.Account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String surname;
	private String psw;
	private int balance;
	
	public User() {
	}

	public User(int id,String name, String surname, String psw, int balance) {
		super();
		this.id=id;
		this.name = name;
		this.surname = surname;
		this.psw = psw;
		this.balance = balance;
	}

}

