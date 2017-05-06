/**
 * Created by Naresh Siramsetty on 5/5/17.
 */

package com.dius.agile.DashBoardImpl.CardItem;

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

    public CardItem(String cardTitle,String cardDescription, Integer cardEstimate) {
        this.cardTitle = cardTitle;
        this.cardDescription = cardDescription;
        this.cardEstimate = cardEstimate;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }
}
