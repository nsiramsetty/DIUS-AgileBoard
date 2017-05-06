/**
 * Created by Naresh Siramsetty on 5/5/17.
 */

package com.dius.agile.DashBoard.CardItem;

public class CardItemKey {

    private String cardTitle;

    public CardItemKey(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardItemKey that = (CardItemKey) o;

        return cardTitle != null ? cardTitle.equals(that.cardTitle) : that.cardTitle == null;

    }

    @Override
    public int hashCode() {
        return cardTitle != null ? cardTitle.hashCode() : 0;
    }
}