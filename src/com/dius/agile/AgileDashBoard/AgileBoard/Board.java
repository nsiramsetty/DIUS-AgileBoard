/**
 * Created by Naresh Siramsetty on 5/5/17.
 */

package com.dius.agile.AgileDashBoard.AgileBoard;

import com.dius.agile.AgileDashBoard.AgileCardItem.CardItem;
import com.dius.agile.AgileDashBoard.AgileCardItem.CardItemContent;
import com.dius.agile.AgileDashBoard.AgileCardItem.CardItemKey;
import com.dius.agile.AgileDashBoard.AgileColumns.ColumnCardsMap;
import com.dius.agile.AgileDashBoard.AgileColumns.ColumnKey;
import com.dius.agile.AgileDashBoard.Exceptions.*;
import com.dius.agile.AgileDashBoard.IterationConstants.Constants;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Board {

    public Board(HashMap<ColumnKey, ColumnCardsMap> boardColumnsMap) {
        this.boardColumnsMap = boardColumnsMap;
    }

    public Board() {
        this.boardColumnsMap = new HashMap<ColumnKey, ColumnCardsMap>();
    }

    public HashMap<ColumnKey, ColumnCardsMap> getBoardColumnsMap() {
        return boardColumnsMap;
    }

    public void setBoardColumnsMap(HashMap<ColumnKey, ColumnCardsMap> boardColumnsMap) {
        this.boardColumnsMap = boardColumnsMap;
    }

    private HashMap<ColumnKey, ColumnCardsMap> boardColumnsMap;

    public void addColumn(String columnName) {
        try {
            ColumnKey columnKey = new ColumnKey(columnName);
            if (boardColumnsMap.containsKey(columnKey)) {
                throw new ColumnAlreadyExistException(columnName);
            } else {
                ColumnCardsMap columnCardsMap = new ColumnCardsMap();
                boardColumnsMap.put(columnKey, columnCardsMap);
            }
        } catch (ColumnAlreadyExistException caeException) {
            caeException.printStackTrace();
        }
    }

    public Boolean canAddCardItem(CardItem cardItem, String columnName)
            throws WIPExceededException, ColumnNotFoundException, CardAlreadyExistsException {
        ColumnKey columnKey = new ColumnKey(columnName);
        CardItemKey cardItemKey = new CardItemKey(cardItem.getCardTitle());
        if (!boardColumnsMap.containsKey(columnKey)) {
            throw new ColumnNotFoundException(columnName);
        } else {
            Integer iterationPointsCount = boardColumnsMap.get(columnKey).getColumnEstimate() + cardItem.getCardEstimate();
            if (iterationPointsCount >  Constants.WIP_LIMIT) {
                throw new WIPExceededException(cardItem, iterationPointsCount, columnName);
            } else if (boardColumnsMap.get(columnKey).getColumnCardMap().containsKey(cardItemKey)) {
                throw new CardAlreadyExistsException(cardItem, columnName);
            } else {
                return true;
            }
        }
    }

    public void addCardItem(CardItem cardItem, String columnName) throws CardAlreadyExistsException {
        CardItemKey cardItemKey = new CardItemKey(cardItem.getCardTitle());
        ColumnKey columnKey = new ColumnKey(columnName);
        if (boardColumnsMap.get(columnKey).getColumnCardMap().containsKey(cardItemKey)) {
            throw new CardAlreadyExistsException(cardItem, columnName);
        } else {
            CardItemContent cardItemContent = new CardItemContent(cardItem.getCardDescription(), cardItem.getCardEstimate());
            boardColumnsMap.get(columnKey).getColumnCardMap().put(cardItemKey, cardItemContent);
        }
    }

    public void removeCardItem(CardItem cardItem, String columnName) throws CardNotFoundException {
        CardItemKey cardItemKey = new CardItemKey(cardItem.getCardTitle());
        ColumnKey columnKey = new ColumnKey(columnName);
        if (!boardColumnsMap.get(columnKey).getColumnCardMap().containsKey(cardItemKey)) {
            throw new CardNotFoundException(cardItem, columnName);
        } else {
            boardColumnsMap.get(columnKey).getColumnCardMap().remove(cardItemKey);
        }
    }

    public void printBoard() {
        Set<ColumnKey> columnKeySet = boardColumnsMap.keySet();
        Iterator<ColumnKey> columnKeyIterator = columnKeySet.iterator();
        while (columnKeyIterator.hasNext()) {
            ColumnKey columnKey = columnKeyIterator.next();
            ColumnCardsMap columnCardsMap = boardColumnsMap.get(columnKey);
            System.out.println("Cards in Column : " + columnKey.getColumnName() +
                    " : Count : " + columnCardsMap.getColumnCardMap().size());
            columnCardsMap.printColumnCards();
        }
    }
}