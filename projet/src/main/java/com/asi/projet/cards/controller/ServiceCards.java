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
	 * Initialise les 5 premières cartes d'un utilisateur à la création de son compte à partir d'un tirage aléatoire de Templates.
	 */
	public void initCards(int idUser) {
		// init index
		int i;
		// Récupération de l'id du User
		//int idUser = 1;
	    // Récupération de la liste des ids des Templates des Cartes
	    List<Templates> ListIdTemplates = rTemplates.findAll();
	    int nbTemplates = ListIdTemplates.size();
	    
	    for (i = 0; i < 5; i++) {
	    	int rd = new Random().nextInt(nbTemplates);
	    	Templates rdTemplateId = ListIdTemplates.get(rd);
	    	createCard(idUser,rdTemplateId.getIdTemplate());
	    }
	}
	
	/**
	 * Créé une carte dans la database pour un utilisateur décrit pas idUser.
	 * @param idUser
	 * @param idTemplate
	 */
	public void createCard(int idUser, int idTemplate) {
		Cards card = new Cards();
    	card.setId_User(idUser);
    	card.setId_Template(idTemplate);
    	rCards.save(card);
	}
	
	/**
	 * Supprime de la database la carte décrite par idCard
	 * @param idCard
	 */
	public void deleteCard(int idCard) {
		Cards card = rCards.findById(idCard).get();
		rCards.delete(card);
	}
	
	/**
	 * @param idTemplates
	 * @return Prix d'achat de la carte
	 */
	public int getBuyPrice(int idTemplates) {
		Optional<Templates> template = rTemplates.findById(idTemplates);
		return template.get().getBuyPrice();
	}
	
	/**
	 * 
	 * @param idTemplates
	 * @return Prix de vente de la carte
	 */
	public int getSellPrice(int idTemplates) {
		Optional<Templates> template = rTemplates.findById(idTemplates);
		return template.get().getSellPrice();
	}
	
	/**
	 * 
	 * @param idCard
	 * @return id du Template lié à la carte
	 */
	public int getTemplateFromCard(int idCard) {
		Optional<Cards> card = rCards.findById(idCard);
		return card.get().getId_Template();
	}
	
	/**
	 * 
	 * @param idUser
	 * @return List des cartes possédées par l'utilisateur décrit pas idUser
	 */
	public List<Cards> getListCardsUser(int idUser) {
		List<Cards> res = rCards.findAllByIdUser(idUser);
		return res;
	}
	
	/**
	 * Renvoie toutes les cartes à vendre dans le market
	 * @return List des cartes dans le templates
	 */
	public List<Templates> getListCardsMarket() {
		List<Templates> res = rTemplates.findAll();
		return res;
	}
	
}
