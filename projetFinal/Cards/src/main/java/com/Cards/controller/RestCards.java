package com.Cards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.CardsDTO.CardsDTO;
import com.TemplateDTO.TemplateDTO;

import java.util.List;


@RestController
public class RestCards {
	@Autowired
	private final ServiceCards sCards;

	RestCards(ServiceCards serviceCards) {
		this.sCards = serviceCards;
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/deck")
	public Iterable<CardsDTO> listDeck(@RequestBody CardsDTO body) {
		return sCards.getListCardsUser(body);
	}

	@PostMapping(value = "/card")
	public void postCard(@RequestBody CardsDTO body){
	}

	@DeleteMapping(value = "/card/{id}")
	public void deleteCard(@PathVariable String id){
		sCards.deleteCard(id);
	}

	@GetMapping(value = "/card/{id}")
	public CardsDTO getCard(@PathVariable String id){
		return sCards.getCardById(id);
	}

}
