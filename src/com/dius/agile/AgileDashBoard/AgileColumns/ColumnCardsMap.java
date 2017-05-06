/**
 * Created by Naresh Siramsetty on 5/5/17.
 */

package com.dius.agile.AgileDashBoard.AgileColumns;

import com.dius.agile.AgileDashBoard.AgileCardItem.CardItem;
import com.dius.agile.AgileDashBoard.AgileCardItem.CardItemContent;
import com.dius.agile.AgileDashBoard.AgileCardItem.CardItemKey;
import com.dius.agile.AgileDashBoard.Exceptions.CardAlreadyExistsException;
import com.dius.agile.AgileDashBoard.Exceptions.CardNotFoundException;
import com.dius.agile.AgileDashBoard.Exceptions.WIPExceededException;
import com.dius.agile.AgileDashBoard.IterationConstants.Constants;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ColumnCardsMap {
    private HashMap<CardItemKey, CardItemContent> columnCardMap;

    public ColumnCardsMap(HashMap<CardItemKey, CardItemContent> columnCardMap) {
        this.columnCardMap = columnCardMap;
    }

    public ColumnCardsMap() {
        this.columnCardMap = new HashMap<CardItemKey, CardItemContent>();
    }

    public HashMap<CardItemKey, CardItemContent> getColumnCardMap() {
        return columnCardMap;
    }

    public void setColumnCardMap(HashMap<CardItemKey, CardItemContent> columnCardMap) {
        this.columnCardMap = columnCardMap;
    }

    public Integer getColumnEstimate() {
        Set<CardItemKey> cardItemKeySet = columnCardMap.keySet();
        Iterator<CardItemKey> cardItemKeyIterator = cardItemKeySet.iterator();
        Integer iterationPointsCount = 0;
        while (cardItemKeyIterator.hasNext()) {
            iterationPointsCount += columnCardMap.get(cardItemKeyIterator.next()).getCardEstimate();
        }
        return iterationPointsCount;
    }

    public void printColumnCards(){
        Set<CardItemKey> cardItemKeySet = columnCardMap.keySet();
        Iterator<CardItemKey> cardItemKeyIterator = cardItemKeySet.iterator();
        while (cardItemKeyIterator.hasNext()) {
            CardItemKey cardItemKey=cardItemKeyIterator.next();
            CardItemContent cardItemContent=columnCardMap.get(cardItemKey);
            System.out.print("\t");
            System.out.println("Card Item -> Title : " +cardItemKey.getCardTitle()+
                    " -> Description : "+cardItemContent.getCardDescription()+
                    " -> Estimate : "+cardItemContent.getCardEstimate());
        }
    }
}