package com.asi.projet.cards.controller;

import org.springframework.stereotype.Service;

import com.asi.projet.Account.controller.RepositoryAccount;

@Service
public class ServiceInitCards {

	private final RepositoryAccount rAccount;
	private final RepositoryCards rCards;
	
	public ServiceInitCards(RepositoryCards repositoryCards, RepositoryAccount repositoryAccount) {
		this.rAccount = repositoryAccount;
		this.rCards = repositoryCards;
	}
	
	/**
	 * @return String : Json list des cartes
	 */
	public void initCards() {
		// init index
		int i;
		// Récupération de l'id du User
	    int idUser = rAccount.getUser()['id'];
	    // Récupération de la liste des ids des Templates des Cartes
	    List<int> ListIdTemplates = rCards.getTemplates();
	    int nbTemplates = len(ListIdTemplates);
	    
	    for (i = 0; i < 5; i++) {
	    	int rd = getRandomInt(nbTemplates);
	    	int rdTemplateId = ListIdTemplates[rd];
	    	rCards.createCard(idUser, rdTemplateId);
	    }
	}
	
}
