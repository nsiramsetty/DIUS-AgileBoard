package com.dius.agile.AgileDashBoard.Exceptions;

import com.dius.agile.AgileDashBoard.AgileCardItem.CardItem;
import com.dius.agile.AgileDashBoard.IterationConstants.Constants;

/**
 * Created by nsiramsetty on 5/5/17.
 */
public class WIPExceededException extends Exception {

    public Integer getPointsCount() {
        return pointsCount;
    }

    public void setPointsCount(Integer pointsCount) {
        this.pointsCount = pointsCount;
    }

    private Integer pointsCount;

    public CardItem getCardItem() {
        return cardItem;
    }

    public void setCardItem(CardItem cardItem) {
        this.cardItem = cardItem;
    }

    private CardItem cardItem;

    public WIPExceededException(CardItem cardItem,Integer pointsCount) {
        this.cardItem = cardItem;
        this.pointsCount = pointsCount;
    }

    @Override
    public void printStackTrace() {
        System.out.println("Column WIP exceeded the Limit : "+ Constants.WIP_LIMIT+". Unable to add Card Item with Title \""+cardItem.getCardTitle()+"\" ");
    }
}