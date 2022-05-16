package com.asi.projet.Account.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asi.projet.Account.model.User;
import com.asi.projet.authentification.controller.RepositoryAuthentification;

@Service
public class ServiceAccount {

	@Autowired
	private RepositoryAccount rAccount;
	
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
	public User VerifyRegister(String login, String psw) {
		int id = 1; //TODO id qui change
		User res = null;
		String listLogin = rLogin.getLogin(); //get login d'authentification
		if(!login.contains(" ") && !login.isBlank()) { //Le login est vide ou contient des espaces ?
			if(!listLogin.contains(login)) { //Le login ne fais pas partit des listes utilisateurs
				User newUser = new User(login, psw, 5000);
				res = rAccount.save(newUser);
			}
		}
		return res;
	}
	
	/**
	 * 
	 * @param idUser
	 * @return
	 */
	public User getUserInfo(String idUser) {
		Optional<User> uOpt = rAccount.findById(Integer.parseInt(idUser));
		
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}	
	
	/**
	 * 
	 * @param price
	 * @param idUser
	 * @return
	 */
	public boolean CheckBalance(int price, int idUser) {
		boolean res = false;
		User u = getUserInfo(Integer.toString(idUser));
		int currentBalance = u.getBalance();
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
		User u = getUserInfo(Integer.toString(idUser));
		int currentBalance = u.getBalance();
		int newBalance = addBalance + currentBalance;
		u.setBalance(newBalance);
		rAccount.save(u);
		return newBalance;
	}
}


