package com.Authentification.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AccountDTO.AccountDTO;
import com.AccountDTO.AccountFormDTO;


@RestController
public class RestAuthentification {
	
	private final ServiceAuthentification sAuthentification;
	
	public RestAuthentification(ServiceAuthentification authentification) {
		this.sAuthentification = authentification;
	}

	@RequestMapping
	public AccountFormDTO Register(@RequestBody AccountFormDTO account) {
		System.out.println("OUI");
		return sAuthentification.VerifyRegister(account.getLogin(), account.getPassword());//sAuthentification.VerifyRegister("test", "testpsw");

	}
}