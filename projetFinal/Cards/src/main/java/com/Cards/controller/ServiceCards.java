package com.Cards.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.CardsDTO.CardsDTO;
import com.TemplateDTO.TemplateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class ServiceCards {

	@Autowired
	private RepositoryCards rCards;

	public ServiceCards(RepositoryCards rCards){
		this.rCards = rCards;
	}

	//TODO Implémenter génération de cartes aléatoires
	/**
	 * Initialise les 5 premières cartes d'un utilisateur à la création de son compte à partir d'un tirage aléatoire de Templates.
	 */
	/*public void initCards(int idUser) {
		// init index
		int i;
		*//*
		 Récupération de l'id du User
		int idUser = 1;
		 Récupération de la liste des ids des Templates des Cartes
		*//*
		List<TemplateDTO> ListIdTemplates = rTemplates.findAll();
	    int nbTemplates = ListIdTemplates.size();
	    
	    for (i = 0; i < 5; i++) {
	    	int rd = new Random().nextInt(nbTemplates);
	    	Template rdTemplateId = ListIdTemplates.get(rd);
	    	createCard(idUser,rdTemplateId.getIdTemplate());
	    }
	}*/
	
	/**
	 * Créé une carte dans la database pour un utilisateur décrit pas idUser.
	 * @param cardsDTO instance de cards à ajouter
	 */
	public void createCard(CardsDTO cardsDTO) {
		if(cardsDTO.getId_User() != null && cardsDTO.getId_Template() != null){
			//TODO Vérifier que les ids existent dans les tables Template et Account
			rCards.save(cardsDTO);
		}else{
			throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	/**
	 * Supprime de la database la carte décrite par idCard
	 * @param sIdCard
	 */
	public void deleteCard(String sIdCard) {
		int idCard = Integer.parseInt(sIdCard);
		CardsDTO card = rCards.findById(idCard).get();
		rCards.delete(card);
	}

	/**
	 *
	 * @param sIdCard id de la carte
	 * @return la carte si elle existe
	 */
	public CardsDTO getCardById(String sIdCard){
		int idCard = Integer.parseInt(sIdCard);
		Optional<CardsDTO> oCard = rCards.findById(idCard);
		if(oCard.isPresent()){
			return oCard.get();
		}else{
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * 
	 * @param body body de la requête contenant l'id utilisateur
	 * @return List des cartes possédées par l'utilisateur décrit pas idUser
	 */
	public Iterable<CardsDTO> getListCardsUser(CardsDTO body) {
		if(body.getId_User() != null){
			int userId = body.getId_User();
			return rCards.selectCardsByUserId(userId);
		}else{
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
	}

}
