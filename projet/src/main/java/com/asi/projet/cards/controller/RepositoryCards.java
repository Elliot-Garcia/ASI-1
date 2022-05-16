package com.asi.projet.cards.controller;

import org.springframework.data.repository.CrudRepository;
import com.asi.projet.cards.model.Cards;

public interface RepositoryCards extends CrudRepository<Cards, Integer> {
	
}
