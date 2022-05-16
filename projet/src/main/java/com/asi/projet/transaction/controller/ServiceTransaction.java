package com.asi.projet.transaction.controller;

import com.asi.projet.cards.controller.ServiceListing;
import org.springframework.stereotype.Service;

@Service
public class ServiceTransaction {

    ServiceTransaction(){}

    /**
     * Buy transaction
     *  Get card price
     *  Check user balance
     *  Change user balance
     *  Create card
     * @return transaction result
     */
    public boolean buy(BuyBody body) {
        int userId = body.getUserId();
        int cardTemplateId = body.getCardTemplateId();
        int cardPrice = ServiceListing.getCardPrice();
        boolean enoughBalance = ServiceAccount.checkBalance();
        if (enoughBalance){
            ServiceAccount.balanceAdd(-cardPrice);
            RepositoryCards.createCard(cardTemplateId, userId);
        }
        return enoughBalance;
    }

    /**
     * Sell transaction
     *  (Check card ownership)
     *  Get card price
     *  Change user balance
     *  Delete card
     * @return transaction result
     */
    public boolean sell(SellBody body) {
        int userId = body.getUserId();
        int cardId = body.getCardId();
        int cardPrice = ServiceListing.getCardPrice();
        ServiceAccount.balanceAdd(cardPrice);
        Cards.deleteCard(cardId);
    	return true;
    }
}
