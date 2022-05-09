package com.asi.projet.userData.controller;

import org.springframework.stereotype.Service;

@Service
public class RepositoryUserData {
	
	/**
	 * acces to DB 
	 * @return boolean : si connection ok ou non
	 */
	public String getUserData(int idUser) {
		return "Text from DB for userData";
	}
}
