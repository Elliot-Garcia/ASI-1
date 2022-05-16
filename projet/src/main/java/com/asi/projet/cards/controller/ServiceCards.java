package com.asi.projet.cards.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asi.projet.Account.controller.RepositoryAccount;
import com.asi.projet.cards.model.Cards;
import com.asi.projet.cards.model.Templates;

@Service
public class ServiceCards {

	@Autowired
	private final RepositoryAccount rAccount;
	@Autowired
	private final RepositoryCards rCards;
	@Autowired
	private final RepositoryTemplates rTemplates;
	
	public ServiceCards(RepositoryCards repositoryCards, RepositoryAccount repositoryAccount, RepositoryTemplates repositoryTemplates) {
		this.rAccount = repositoryAccount;
		this.rCards = repositoryCards;
		this.rTemplates = repositoryTemplates;
	}
	
	/**
	 * @return String : Json list des cartes
	 */
	public void initCards() {
		// init index
		int i;
		// Récupération de l'id du User
	    int idUser = 1;//rAccount.getUser();
	    // Récupération de la liste des ids des Templates des Cartes
	    List<Templates> ListIdTemplates = rTemplates.findAll();
	    int nbTemplates = ListIdTemplates.size();
	    
	    for (i = 0; i < 5; i++) {
	    	int rd = new Random().nextInt(nbTemplates);
	    	Templates rdTemplateId = ListIdTemplates.get(rd);
	    	createCard(idUser,rdTemplateId.getIdTemplate());
	    }
	}
	
	public void createCard(int idUser, int idTemplate) {
		Cards card = new Cards();
    	
    	card.setId_User(idUser);
    	card.setId_Template(idTemplate);
    	rCards.save(card);
	}
	
	public int getBuyPrice(int idTemplates) {
		Optional<Templates> template = rTemplates.findById(idTemplates);
		return template.get().getBuyPrice();
	}
	
	public int getSellPrice(int idTemplates) {
		Optional<Templates> template = rTemplates.findById(idTemplates);
		return template.get().getSellPrice();
	}
	
	public int getTemplateFromCard(int idCard) {
		Optional<Cards> card = rCards.findById(idCard);
		return card.get().getId_Template();
	}
	
}
