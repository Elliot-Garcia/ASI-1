package com.asi.projet.transaction.controller;

import com.asi.projet.Account.controller.ServiceAccount;
import com.asi.projet.cards.controller.RepositoryCards;
import com.asi.projet.cards.controller.ServiceListing;
import com.asi.projet.cards.model.Cards;
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
        int cardTemplateBuyPrice = ServiceListing.getBuyPrice(cardTemplateId);
        boolean enoughBalance = ServiceAccount.CheckBalance(cardTemplateBuyPrice, userId);
        if (enoughBalance){
            ServiceAccount.balanceAdd(-cardPrice, userId);
            RepositoryCards.createCard(userId, cardTemplateId);
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
        int cardTemplateId = ServiceCards.getTemplateFromCard(cardId);
        int cardPrice = ServiceListing.getCardSellPrice(cardTemplateId);
        ServiceAccount.balanceAdd(cardPrice, userId);
        Cards.deleteCard(cardId);
    	return true;
    }
}
