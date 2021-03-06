/**
 * Created by Naresh Siramsetty on 5/5/17.
 */

package com.dius.agile.DashBoardImpl.Exceptions;

import com.dius.agile.DashBoardImpl.CardItem.CardItem;
import com.dius.agile.DashBoardImpl.Constants.Constants;

public class WIPExceededException extends Exception {

    public Integer getPointsCount() {
        return pointsCount;
    }

    public void setPointsCount(Integer pointsCount) {
        this.pointsCount = pointsCount;
    }

    private Integer pointsCount;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    private String columnName;

    public CardItem getCardItem() {
        return cardItem;
    }

    public void setCardItem(CardItem cardItem) {
        this.cardItem = cardItem;
    }

    private CardItem cardItem;

    public WIPExceededException(CardItem cardItem, Integer pointsCount, String columnName) {
        this.cardItem = cardItem;
        this.pointsCount = pointsCount;
        this.columnName = columnName;
    }

    @Override
    public void printStackTrace() {
        System.out.println("Exception : Column WIP exceeded the Limit : "
                + Constants.WIP_LIMIT + ". Unable to add Card Item with Title \""
                + cardItem.getCardTitle() + "\"\n and Estimate \""
                + cardItem.getCardEstimate() + "\" to Column \""
                + columnName + "\" with an existing total Estimate of \""
                + (pointsCount - cardItem.getCardEstimate()) + "\"");
    }
}