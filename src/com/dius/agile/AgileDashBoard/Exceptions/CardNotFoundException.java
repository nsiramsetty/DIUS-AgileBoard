/**
 * Created by Naresh Siramsetty on 5/5/17.
 */

package com.dius.agile.AgileDashBoard.Exceptions;

import com.dius.agile.AgileDashBoard.AgileCardItem.CardItem;

public class CardNotFoundException extends Exception {

    public CardNotFoundException(CardItem cardItem, String columnName) {
        this.cardItem = cardItem;
        this.columnName = columnName;
    }

    public CardItem getCardItem() {
        return cardItem;
    }

    public void setCardItem(CardItem cardItem) {
        this.cardItem = cardItem;
    }

    private CardItem cardItem;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    private String columnName;

    @Override
    public void printStackTrace() {
        System.out.println("Card Item with Title \"" +
                cardItem.getCardTitle() + "\" not found in this column \"" + columnName + "\"");
    }
}
