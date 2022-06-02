package com.Cards.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.asi.projet.cards.model.Cards;


public class RepositoryCards {
	
	@Query("Select c FROM Cards c WHERE c.id_User = ?1")
	List<CardsDTO> findAllByIdUser(int idUser);
	
}
