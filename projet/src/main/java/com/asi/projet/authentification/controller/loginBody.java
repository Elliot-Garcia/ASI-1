package com.asi.projet.authentification.controller;


public class loginBody {
	
	private String login;
	private String password;
	
	public loginBody(){
	}
	

	public String getLogin() {
		return this.login;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setlogin( String login) {
		this.login = login;
	}
	
	public void setPassword( String password) {
		this.password = password;
	}
		
}