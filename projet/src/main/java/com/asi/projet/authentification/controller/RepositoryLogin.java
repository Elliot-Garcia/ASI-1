package com.asi.projet.authentification.controller;

import org.springframework.stereotype.Service;

@Service
public class RepositoryLogin {
	
	/**
	 * acces to DB 
	 * @return boolean : si connection ok ou non
	 */
	public String connect() {
		return "Text from DB";
	}
}
