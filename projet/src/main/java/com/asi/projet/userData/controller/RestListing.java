package com.asi.projet.userData.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asi.projet.authentification.controller.ServiceLogin;

public class RestListing {
	
	private final ServiceListing sListing;
	
	RestLogin(ServiceListing serviceListing) {
		this.sListing = serviceListing;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listing")
	public String listCards(@RequestParam String idLister) {
		return sListing.listCards(idLister);
	}
}
