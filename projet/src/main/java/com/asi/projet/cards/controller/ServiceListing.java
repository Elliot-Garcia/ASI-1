package com.asi.projet.cards.controller;

public class ServiceListing {
	
	private final RepositoryListing rListing;
	
	public ServiceListing(RepositoryListing repositoryListing) {
		this.rListing = repositoryListing;
	}
	
	/**
	 * requete le repository :
	 * @return String : Json list des cartes
	 */
	public String listCards(String idLister) {
	    int intIdLister=Integer.parseInt(idLister);  
		String res;
		if (idLister == null) {
			res = rListing.listCards();
		}
		else {
			res = rListing.listCards(intIdLister);
		}
		return res;
	}
}
