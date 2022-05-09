package com.asi.projet.transaction.controller;

public class BuyBody {
    private int cardTemplateId;
    private int userId;

    public int getCardTemplateId(){
        return this.cardTemplateId;
    }

    public int getUserId(){
        return this.userId;
    }
}
