package com.asi.projet.cards.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.asi.projet.cards.model.Cards;

public interface RepositoryCards extends CrudRepository<Cards, Integer> {
	
	@Query("Select * FROM Cards WHERE Cards.id_User = ?1")
	List<Cards> findAllByIdUser(int idUser);
	
}
