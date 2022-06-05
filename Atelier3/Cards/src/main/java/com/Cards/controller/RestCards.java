package com.Cards.controller;

import com.CardsDTO.CardsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

	@PostMapping()
	public void postCard(@RequestBody CardsDTO body){
		sCards.createCard(body);
	}

	@DeleteMapping(value = "/card/{id}")
	public void deleteCard(@PathVariable String id){
		sCards.deleteCard(id);
	}

	@GetMapping(value = "/card/{id}")
	public CardsDTO getCard(@PathVariable String id){
		return sCards.getCardById(id);
	}


	@GetMapping(value = "/find/{userId}/{templateId}")
	public CardsDTO findCard(@PathVariable String userId, @PathVariable String templateId){
		return sCards.findCard(userId, templateId);
	}
}
