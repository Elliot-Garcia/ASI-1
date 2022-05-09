package com.asi.projet.userData.controller;

import org.springframework.stereotype.Service;

import com.asi.projet.authentification.controller.RepositoryLogin;

@Service
public class ServiceUserData {

private final RepositoryUserData rUserData;
	
	public ServiceUserData(RepositoryUserData repositoryUserData) {
		this.rUserData = repositoryUserData;
	}
	
	/**
	 * requete le repository :
	 * @return boolean : si connection ok ou non
	 */
	public boolean connect() {
		//requet a la db
		String DB = rUserData.connect();
		
		// determination de true false
		if (DB.equals("OUI")) {
			return true;
		}
		
		return false;
	}
	
	

}

