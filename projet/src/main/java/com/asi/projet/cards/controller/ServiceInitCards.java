package com.asi.projet.cards.controller;

import org.springframework.stereotype.Service;

@Service
public class ServiceInitCards {

	private final RepositoryGetUser rGetUser;
	private final RepositoryGetTemplates rGetTemplates;
	private final RepositoryCreateCard rCreateCard;
	
	public ServiceInitCards(RepositoryCreateCard repositoryCreateCard, RepositoryGetTemplates repositoryGetTemplates, RepositoryGetUser repositoryGetUser) {
		this.rGetUser = repositoryGetUser;
		this.rGetTemplates = repositoryGetTemplates;
		this.rCreateCard = repositoryCreateCard;
	}
	
	/**
	 * @return String : Json list des cartes
	 */
	public void initCards() {
		// init index
		int i;
		// Récupération de l'id du User
	    int idUser = rGetUser.getUser['id'];
	    // Récupération de la liste des ids des Templates des Cartes
	    List<int> ListIdTemplates = rGetTemplates.getTemplates();
	    int nbTemplates = len(ListIdTemplates);
	    
	    for (i = 0; i < 5; i++) {
	    	int rd = getRandomInt(nbTemplates);
	    	int rdTemplateId = ListIdTemplates[rd];
	    	rCreateCard.create(idUser, rdTemplateId);
	    }
	}
	
}
