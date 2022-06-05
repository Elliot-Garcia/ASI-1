package com.Account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.AccountDTO.AccountFormDTO;

@Entity
public class AccountBody {
	@Id
	@GeneratedValue
	private Integer id;
	private String login;
	private String password;
	private int balance;
	
	public AccountBody() {
	}

	public AccountBody(String login, String psw, int balance) {
		super();
		this.id=0;
		this.login = login;
		this.password = psw;
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPsw() {
		return password;
	}

	public void setPsw(String psw) {
		this.password = psw;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "{id:" + id + ",login:" + login + ",psw:" + password + ",balance:" + balance + "}";
	}


	
}


