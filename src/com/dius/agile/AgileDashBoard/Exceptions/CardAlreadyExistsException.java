package com.dius.agile.AgileDashBoard.Exceptions;

import com.dius.agile.AgileDashBoard.AgileCardItem.CardItem;

/**
 * Created by nsiramsetty on 5/5/17.
 */
public class CardAlreadyExistsException extends Exception {

    public CardAlreadyExistsException(CardItem cardItem) {
        this.cardItem = cardItem;
    }

    public CardItem getCardItem() {
        return cardItem;
    }

    public void setCardItem(CardItem cardItem) {
        this.cardItem = cardItem;
    }

    private CardItem cardItem;

    @Override
    public void printStackTrace() {
        System.out.println("Card Item with Title \""+cardItem.getCardTitle()+"\" already exists in this column.");
    }
}