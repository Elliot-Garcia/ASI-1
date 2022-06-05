package com.asi.projet.authentification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAuthentification {
	
	@Autowired
	private final RepositoryAuthentification rAuthentification;
	
	public ServiceAuthentification(RepositoryAuthentification repositoryAuthentification) {
		this.rAuthentification = repositoryAuthentification;
	}
	
	/**
	 * check if login and passwords or valide
	 * @return boolean : si connection ok ou non
	 */
	public boolean checkCredentials(String login, String password) {	
		System.out.println( rAuthentification.getPasswordWithLogin(login) );
		
		return rAuthentification.getPasswordWithLogin(login).equals(login);
	}
}
