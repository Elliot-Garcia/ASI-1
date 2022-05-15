package com.asi.projet.authentification.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthentification {
	
	private final ServiceAuthentification sAuthentification;
	
	RestAuthentification(ServiceAuthentification serviceAuthentification) {
		this.sAuthentification = serviceAuthentification;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public boolean login(@RequestBody loginBody body) {
		return sAuthentification.checkCredentials(body.getLogin(), body.getPassword());
	}
}