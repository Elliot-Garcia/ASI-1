package com.Cards.controller;

import org.springframework.web.bind.annotation.RestController;

import com.CardsDTO.CardsDTO;
import com.TemplateDTO.TemplateDTO;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
public class RestCards {
	private final ServiceCards sCards;
	

	RestCards(ServiceCards serviceCards) {
		this.sCards = serviceCards;
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/deck")
	public List<CardsDTO> listDeck(@RequestBody CardsDTO idUser) {
		//return sCards.getListCardsUser(idUser.getIdUser());
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/market")
	public List<TemplateDTO> listDeck() {
		return sCards.getListCardsMarket();
	}

}
