package com.asi.projet.authentification.controller;

import org.springframework.stereotype.Service;

@Service
public class ServiceAuthentification {
	
	private final RepositoryAuthentification rAuthentification;
	
	public ServiceAuthentification(RepositoryAuthentification repositoryAuthentification) {
		this.rAuthentification = repositoryAuthentification;
	}
	
	/**
	 * check if login and passwords or valide
	 * @return boolean : si connection ok ou non
	 */
	public boolean checkCredentials(String login, String password) {		
		return rAuthentification.getPasswordWithLogin(login).equals(login);
	}
}
