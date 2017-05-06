/**
 * Created by Naresh Siramsetty on 5/5/17.
 */

package com.dius.agile.DashBoardImpl.Exceptions;

import com.dius.agile.DashBoardImpl.CardItem.CardItem;

public class CardAlreadyExistsException extends Exception {

    public CardAlreadyExistsException(CardItem cardItem, String columnName) {
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
        System.out.println("Exception : Card Item with Title \""
                + cardItem.getCardTitle() + "\" already exists in this column \"" + columnName + "\"");
    }
}