package com.asi.projet.cards.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asi.projet.cards.model.Cards;
import com.asi.projet.cards.model.Templates;

@RestController
public class RestCards {
	
	private final ServiceCards sCards;
	
	RestCards(ServiceCards serviceCards) {
		this.sCards = serviceCards;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/deck")
	public List<Cards> listDeck(@RequestParam int idUser) {
		return sCards.getListCardsUser(idUser);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/market")
	public List<Templates> listDeck() {
		return sCards.getListCardsMarket();
	}
}
