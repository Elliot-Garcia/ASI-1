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
	public String getUserData(String idUser) {
		return rUserData.getUserData(Integer.parseInt(idUser));
	}
	
	

}

