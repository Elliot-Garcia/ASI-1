package com.asi.projet.transaction.controller;

import com.asi.projet.Account.controller.ServiceAccount;
import com.asi.projet.cards.controller.ServiceCards;
import org.springframework.stereotype.Service;

@Service
public class ServiceTransaction {

    private final ServiceAccount serviceAccount;
    private final ServiceCards serviceCards;

    ServiceTransaction(ServiceAccount serviceAccount, ServiceCards serviceCards){
        this.serviceAccount = serviceAccount;
        this.serviceCards = serviceCards;
    }

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
        int cardTemplateBuyPrice = serviceCards.getBuyPrice(cardTemplateId);
        boolean enoughBalance = serviceAccount.CheckBalance(cardTemplateBuyPrice, userId);
        if (enoughBalance){
            serviceAccount.balanceAdd(-cardTemplateBuyPrice, userId);
            serviceCards.createCard(userId, cardTemplateId);
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
        int cardTemplateId = serviceCards.getTemplateFromCard(cardId);
        int cardPrice = serviceCards.getSellPrice(cardTemplateId);
        serviceAccount.balanceAdd(cardPrice, userId);
        serviceCards.deleteCard(cardId);
    	return true;
    }
}
