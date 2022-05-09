package com.asi.projet.Account.controller;

import org.springframework.stereotype.Service;

@Service
public class RepositoryAccount {
	
	/**
	 * 
	 * @return 
	 */
	public String getUser() {
		return "Text from DB for userData";
	}
	
	public String CreateAccount(String login, String psw) {
		return "hjhjhjhj";
	}
	
	public String getUserInfo(int idUser) {
		return "Text from DB for userData";
	}
	
	public int getBalance(int idUser) {
		return 0;
	}
	
	public boolean changeBalance(int addBalance, int currentBalance) {
		return true;
	}
}
