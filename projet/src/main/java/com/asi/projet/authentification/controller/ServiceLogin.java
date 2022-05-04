package com.asi.projet.authentification.controller;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ServiceLogin {
	
	private final RepositoryLogin rLogin;
	
	ServiceLogin(RepositoryLogin repositoryLogin) {
		this.rLogin = repositoryLogin;
	}
	
	/**
	 * requete le repository :
	 * @return boolean : si connection ok ou non
	 */
	public boolean connect() {
		//requet a la db
		// determination de true false
		return false;
	}
	
	

}
