package com.asi.projet.cards.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class RestListing {
	
	private final ServiceListing sListing;
	
	RestListing(ServiceListing serviceListing) {
		this.sListing = serviceListing;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listing")
	public String listCards(@RequestParam String idLister) {
		return "NTM";//sListing.listCards(idLister);
	}
}
