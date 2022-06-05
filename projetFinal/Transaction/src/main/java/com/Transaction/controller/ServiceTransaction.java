package com.Transaction.controller;

import com.Transaction.controller.request.RequestToAccount;
import com.Transaction.controller.request.RequestToCards;
import com.Transaction.controller.request.RequestToTemplate;
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
     * @param sUserId user id as string
     * @param sTemplateId template id as string
     *  Get card price
     *  Check user balance
     *  Change user balance
     *  Create card
     * @return transaction complete
     */
    public boolean buy(String sUserId, String sTemplateId) {
        int userId = Integer.parseInt(sUserId);
        int templateId = Integer.parseInt(sTemplateId);
        int cardTemplateBuyPrice = rtTemplate.getTemplate(templateId).getBuyPrice();
        int userBalance = rtAccount.getAccount(userId).getBalance();
        if (cardTemplateBuyPrice <= userBalance){
            rtAccount.addBalance(userId, -cardTemplateBuyPrice);
            rtCards.createCard(userId, templateId);
        }
        return false;
    }

    /**
     * Sell transaction
     * @param sUserId user id as string
     * @param sTemplateId template id as string
     *  Get corresponding card from template and user
     *  Get template sell price
     *  Change user balance
     *  Delete card
     * @return transaction complete
     */
    public boolean sell(String sUserId, String sTemplateId) {
        int userId = Integer.parseInt(sUserId);
        int templateId = Integer.parseInt(sTemplateId);
        int cardId = rtCards.findCard(userId, templateId).getId_Card();
        int cardPrice = rtTemplate.getTemplate(templateId).getSellPrice();
        rtAccount.addBalance(userId, cardPrice);
        rtCards.deleteCard(cardId);
        return true;
    }

}
