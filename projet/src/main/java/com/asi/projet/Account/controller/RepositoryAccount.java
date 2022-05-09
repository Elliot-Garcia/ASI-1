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
	
	/**
	 * 
	 * @param login
	 * @param psw
	 * @return
	 */
	public String CreateAccount(String login, String psw) {
		return "hjhjhjhj";
	}
	
	/**
	 * 
	 * @param idUser
	 * @return
	 */
	public String getUserInfo(int idUser) {
		return "Text from DB for userData";
	}
	
	/**
	 * 
	 * @param idUser
	 * @return
	 */
	public int getBalance(int idUser) {
		return 0;
	}
	
	/**
	 * 
	 * @param addBalance
	 * @param currentBalance
	 * @return
	 */
	public int changeBalance(int addBalance, int currentBalance) {
		return 0;
	}
}
