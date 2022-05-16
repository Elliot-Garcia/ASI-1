package com.asi.projet.Account.controller;


import org.springframework.stereotype.Service;

import com.asi.projet.authentification.controller.RepositoryAuthentification;

@Service
public class ServiceAccount {

private final RepositoryAccount rAccount;
private final RepositoryAuthentification rLogin;
	
	public ServiceAccount(RepositoryAccount repositoryAccount, RepositoryAuthentification repositoryAuthentification) {
		this.rAccount = repositoryAccount;
		this.rLogin = repositoryAuthentification;
	}
	
	/**
	 * 
	 * @param login
	 * @param psw
	 * @return
	 */
	public String VerifyRegister(String login, String psw) {
		String res = null;
		String listLogin = rLogin.getLogin(); //get login d'authentification
		if(!listLogin.contains(login)) {
			res = rAccount.CreateAccount(login, psw);
		}
		return res;
	}
	
	/**
	 * 
	 * @param idUser
	 * @return
	 */
	public String getUserInfo(String idUser) {
		return rAccount.getUserInfo(Integer.parseInt(idUser));
	}	
	
	/**
	 * 
	 * @param price
	 * @param idUser
	 * @return
	 */
	public boolean CheckBalance(int price, int idUser) {
		boolean res = false;
		int currentBalance = rAccount.getBalance(idUser);
		if(currentBalance>=price) {
			res = true;
		}
		return res;
	}
	
	/**
	 * 
	 * @param addBalance
	 * @param idUser
	 * @return
	 */
	public int balanceAdd(int addBalance, int idUser) {
		int currentBalance = rAccount.getBalance(idUser);
		return rAccount.changeBalance(addBalance, currentBalance);
	}
}


