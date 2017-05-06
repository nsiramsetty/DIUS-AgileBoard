package com.dius.agile.AgileDashBoard.AgileCardItem;

/**
 * Created by nsiramsetty on 5/5/17.
 */
public class CardItem {

    private String cardTitle;

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }

    private String cardDescription;

    public Integer getCardEstimate() {
        return cardEstimate;
    }

    public void setCardEstimate(Integer cardEstimate) {
        this.cardEstimate = cardEstimate;
    }

    private Integer cardEstimate;

    public CardItem(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }
}
