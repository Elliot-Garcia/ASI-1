package com.Authentification.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AccountDTO.AccountDTO;

@RestController
public class RestAuthentification {
	
	private final ServiceAuthentification sAuthentification;
	
	public RestAuthentification(ServiceAuthentification authentification) {
		this.sAuthentification = authentification;
	}

	@RequestMapping
	public AccountDTO Register() {
		System.out.println("OUI");
		return null;
		//return sAuthentification.VerifyRegister(body.getLogin(), body.getPassword());
	}
}