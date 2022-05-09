package com.asi.projet.cards.controller;

import java.awt.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.asi.projet.cards.model.Cards;

public interface RepositoryCards extends CrudRepository<Cards, Integer> {

	@Query("SELECT t.id_templates FROM templates t")
	List getTemplates();
}
