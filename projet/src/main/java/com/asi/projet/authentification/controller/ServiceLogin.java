package com.asi.projet.authentification.controller;

import org.springframework.stereotype.Service;

@Service
public class ServiceLogin {
	
	private final RepositoryLogin rLogin;
	
	public ServiceLogin(RepositoryLogin repositoryLogin) {
		this.rLogin = repositoryLogin;
	}
	
	/**
	 * requete le repository :
	 * @return boolean : si connection ok ou non
	 */
	public boolean connect() {
		//requet a la db
		String DB = rLogin.connect();
		
		// determination de true false
		if (DB.equals("OUI")) {
			return true;
		}
		
		return false;
	}
	
	

}
