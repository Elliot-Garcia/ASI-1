package com.asi.projet.authentification.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestLogin {
	
	private final ServiceLogin sLogin;
	
	RestLogin(ServiceLogin serviceLogin) {
		this.sLogin = serviceLogin;
	}
	
	@GetMapping("/login")
	public boolean connect() {
		return sLogin.connect();
	}

}
