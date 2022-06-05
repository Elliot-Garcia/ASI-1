package com.asi.projet.cards.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.asi.projet.cards.model.Templates;

public interface RepositoryTemplates extends CrudRepository<Templates, Integer> {

	List<Templates> findAll();
	
}
