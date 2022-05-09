package com.asi.projet.cards.controller;


public interface RepositoryCards extends CrudRepository<Card, Integer> {

	@Query("SELECT t.id_templates FROM templates t")
	List<int> getTemplates();
	
	public List<int> getTemplates();
}
