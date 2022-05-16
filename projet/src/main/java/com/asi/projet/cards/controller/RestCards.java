package com.asi.projet.cards.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class RestCards {
	
	private final ServiceCards sCards;
	
	RestCards(ServiceCards serviceCards) {
		this.sCards = serviceCards;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/deck")
	public void listDeck(@RequestParam String idUser) {
		//return sCards.getListCardsUser(idUser);
	}
}
