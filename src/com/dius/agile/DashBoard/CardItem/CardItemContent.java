/**
 * Created by Naresh Siramsetty on 5/5/17.
 */

package com.dius.agile.DashBoard.CardItem;

public class CardItemContent {

    private String cardDescription;

    public CardItemContent(String cardDescription, Integer cardEstimate) {
        this.cardDescription = cardDescription;
        this.cardEstimate = cardEstimate;
    }

    public Integer getCardEstimate() {
        return cardEstimate;
    }

    public void setCardEstimate(Integer cardEstimate) {
        this.cardEstimate = cardEstimate;
    }

    private Integer cardEstimate;


    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardItemContent that = (CardItemContent) o;

        if (!cardDescription.equals(that.cardDescription)) return false;
        return cardEstimate.equals(that.cardEstimate);

    }

    @Override
    public int hashCode() {
        int result = cardDescription.hashCode();
        result = 31 * result + cardEstimate.hashCode();
        return result;
    }
}