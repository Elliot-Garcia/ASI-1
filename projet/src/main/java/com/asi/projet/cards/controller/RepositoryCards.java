package com.asi.projet.cards.controller;

import java.awt.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.asi.projet.cards.model.Cards;

public interface RepositoryCards extends CrudRepository<Cards, Integer> {

	@Query("")
	Cards createCard();
	
	@Query("")
	Cards deleteCard();
	
	@Query("SELECT * FROM cards c WHERE c.id_Card=?1")
	Cards getCard(int id_card);
	
	//@Query("SELECT t.id_templates FROM templates t")
	//List<Cards> getTemplates();
}
