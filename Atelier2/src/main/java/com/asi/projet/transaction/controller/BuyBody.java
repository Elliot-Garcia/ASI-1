package com.asi.projet.transaction.controller;

public class BuyBody {

    BuyBody(){}

    private int cardTemplateId;
    private int userId;

    public int getCardTemplateId(){
        return this.cardTemplateId;
    }

    public int getUserId(){
        return this.userId;
    }

    public void setCardTemplateId(int cardTemplateId) {
        this.cardTemplateId = cardTemplateId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
