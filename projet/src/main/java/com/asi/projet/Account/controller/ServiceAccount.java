package com.asi.projet.Account.controller;


import org.springframework.stereotype.Service;

import com.asi.projet.authentification.controller.RepositoryLogin;

@Service
public class ServiceAccount {

private final RepositoryAccount rAccount;
private final RepositoryLogin rLogin;
	
	public ServiceAccount(RepositoryAccount repositoryAccount, RepositoryLogin repositoryLogin) {
		this.rAccount = repositoryAccount;
		this.rLogin = repositoryLogin;
	}
	
	/**
	 * requete le repository :
	 * @return boolean : si connection ok ou non
	 */
	public String VerifyRegister(String login, String psw) {
		String res = null;
		String listLogin = rLogin.getLogin(); //get login d'authentification
		if(!listLogin.contains(login)) {
			res = rAccount.CreateAccount(login, psw);
		}
		return res;
	}
	
	public String getUserInfo(String idUser) {
		return rAccount.getUserInfo(Integer.parseInt(idUser));
	}	

	public boolean CheckBalance(int price, int idUser) {
		boolean res = false;
		int currentBalance = rAccount.getBalance(idUser);
		if(currentBalance>=price) {
			res = true;
		}
		return res;
	}
	
	public int balanceAdd(int addBalance, int idUser) {
		int currentBalance = rAccount.getBalance(idUser);
		rAccount.changeBalance(addBalance, currentBalance);
		return 0;
	}
}


