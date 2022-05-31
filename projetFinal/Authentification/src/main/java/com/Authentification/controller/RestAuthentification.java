package com.Authentification.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AccountDTO.AccountDTO;

public class RestAuthentification {
	
	private final ServiceAuthentification sAuthentification;
	
	public RestAuthentification(ServiceAuthentification authentification) {
		this.sAuthentification = authentification;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/account")
	public AccountDTO Register(@RequestBody AuthentificationBody body) {
		return sAuthentification.VerifyRegister(body.getLogin(), body.getPassword());
	}


}
