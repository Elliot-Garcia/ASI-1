package com.Transaction.controller;

import com.Transaction.controller.body.BuyBody;
import com.Transaction.controller.body.SellBody;
import com.Transaction.controller.request.RequestToAccount;
import com.Transaction.controller.request.RequestToCards;
import com.Transaction.controller.request.RequestToTemplate;
import org.apache.coyote.Request;
import org.springframework.stereotype.Service;

@Service
public class ServiceTransaction {

    private final RequestToAccount rtAccount;
    private final RequestToCards rtCards;
    private final RequestToTemplate rtTemplate;


    public ServiceTransaction(RequestToAccount rtAccount, RequestToCards rtCards, RequestToTemplate rtTemplate) {
        this.rtAccount = rtAccount;
        this.rtCards = rtCards;
        this.rtTemplate = rtTemplate;
    }

    /**
     * Buy transaction
     * @param body request body
     *  Get card price
     *  Check user balance
     *  Change user balance
     *  Create card
     * @return transaction complete
     */
    public boolean buy(BuyBody body) {
        int userId = body.getUserId();
        int cardTemplateId = body.getCardTemplateId();
        int cardTemplateBuyPrice = rtTemplate.getTemplate(cardTemplateId).getBuyPrice();
        int userBalance = rtAccount.getAccount(userId).getBalance();
        if (cardTemplateBuyPrice <= userBalance){
            rtAccount.addBalance(userId, -cardTemplateBuyPrice);
            rtCards.createCard(userId, cardTemplateId);
        }
        return false;
    }

    /**
     * Sell transaction
     * @param body request body
     *  Get card price
     *  Change user balance
     *  Delete card
     * @return transaction complete
     */
    public boolean sell(SellBody body) {
        int userId = body.getUserId();
        int cardId = body.getCardId();
        int cardTemplateId = rtCards.getCard(cardId).getId_Template();
        int cardPrice = rtTemplate.getTemplate(cardTemplateId).getSellPrice();
        rtAccount.addBalance(userId, cardPrice);
        rtCards.deleteCard(cardId);
        return true;
    }

}
