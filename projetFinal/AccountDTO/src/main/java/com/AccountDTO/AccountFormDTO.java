package com.AccountDTO;

public class AccountFormDTO {
	private String login;
	private String password;
	private int balance;
	
	public AccountFormDTO() {
	}
	public AccountFormDTO(String login,String password,int balance ) {
		this.balance = balance;
		this.login = login;
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	

}
