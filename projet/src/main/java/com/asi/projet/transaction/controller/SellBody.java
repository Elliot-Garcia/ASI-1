package com.asi.projet.transaction.controller;

public class SellBody {

    SellBody(){}

    private int cardId;

    private int userId;

    public int getCardId(){
        return this.cardId;
    }

    public int getUserId(){
        return this.userId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
