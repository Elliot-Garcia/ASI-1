package com.asi.projet.authentification.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestLogin {
	
	private final ServiceLogin sLogin;
	
	RestLogin(ServiceLogin serviceLogin) {
		this.sLogin = serviceLogin;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public boolean connect() {
		return sLogin.connect();
	}
}