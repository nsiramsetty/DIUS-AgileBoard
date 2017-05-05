package com.dius.agile.AgileDashBoard.AgileColumns;

import com.dius.agile.AgileDashBoard.AgileCardItem.CardItemContent;
import com.dius.agile.AgileDashBoard.AgileCardItem.CardItemKey;

import java.util.HashMap;

/**
 * Created by nsiramsetty on 5/5/17.
 */
public class ColumnCardsMap {
    private HashMap<CardItemKey,CardItemContent> columnCardMap;

    public ColumnCardsMap(HashMap<CardItemKey, CardItemContent> columnCardMap) {
        this.columnCardMap = columnCardMap;
    }

    public ColumnCardsMap() {
        this.columnCardMap = new HashMap<>();
    }

    public HashMap<CardItemKey, CardItemContent> getColumnCardMap() {
        return columnCardMap;
    }

    public void setColumnCardMap(HashMap<CardItemKey, CardItemContent> columnCardMap) {
        this.columnCardMap = columnCardMap;
    }
}