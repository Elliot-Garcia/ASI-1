package com.asi.projet.userData.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asi.projet.authentification.controller.ServiceLogin;

@RestController
public class RestUserData {
	
	private final ServiceUserData sUserData;
	
	RestUserData(ServiceUserData serviceUserData) {
		this.sUserData = serviceUserData;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/userdata")
	public String getUserData(@RequestParam String idUser) {
		return sUserData.getUserData(idUser);
	}
}