package com.dius.agile.AgileDashBoard.LastAction;

import com.dius.agile.AgileDashBoard.AgileCardItem.CardItem;

/**
 * Created by nsiramsetty on 5/5/17.
 */
public class Action {
    private CardItem cardItem;
    private String fromColumnName;
    private String toColumnName;

    public Action(CardItem cardItem, String fromColumnName, String toColumnName) {
        this.cardItem = cardItem;
        this.fromColumnName = fromColumnName;
        this.toColumnName = toColumnName;
    }

    public Action() {
    }

    public CardItem getCardItem() {
        return cardItem;
    }

    public void setCardItem(CardItem cardItem) {
        this.cardItem = cardItem;
    }

    public String getFromColumnName() {
        return fromColumnName;
    }

    public void setFromColumnName(String fromColumnName) {
        this.fromColumnName = fromColumnName;
    }

    public String getToColumnName() {
        return toColumnName;
    }

    public void setToColumnName(String toColumnName) {
        this.toColumnName = toColumnName;
    }
}