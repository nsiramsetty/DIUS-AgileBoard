/**
 * Created by Naresh Siramsetty on 5/5/17.
 */

package com.dius.agile.DashBoardImpl.Board;

import com.dius.agile.DashBoardImpl.CardItem.CardItem;
import com.dius.agile.DashBoardImpl.CardItem.CardItemContent;
import com.dius.agile.DashBoardImpl.CardItem.CardItemKey;
import com.dius.agile.DashBoardImpl.Columns.ColumnCardsMap;
import com.dius.agile.DashBoardImpl.Columns.ColumnKey;
import com.dius.agile.DashBoardImpl.Exceptions.*;
import com.dius.agile.DashBoardImpl.Constants.Constants;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Board {

    private HashMap<ColumnKey, ColumnCardsMap> boardColumnsMap;

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
            if (iterationPointsCount > Constants.WIP_LIMIT) {
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
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------- AGILE DASHBOARD   ------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------");
        while (columnKeyIterator.hasNext()) {
            ColumnKey columnKey = columnKeyIterator.next();
            ColumnCardsMap columnCardsMap = boardColumnsMap.get(columnKey);
            System.out.println("Cards in Column : " + columnKey.getColumnName() +
                    " : Count : " + columnCardsMap.getColumnCardMap().size());
            columnCardsMap.printColumnCards();
        }
    }

    public String getCardItemColumn(CardItem cardItem) throws CardNotFoundException{
        Set<ColumnKey> columnKeySet = boardColumnsMap.keySet();
        Iterator<ColumnKey> columnKeyIterator = columnKeySet.iterator();
        Boolean isCardFoundInAnyColumn = false;
        String columnName = null;
        while (columnKeyIterator.hasNext()) {
            ColumnKey columnKey = columnKeyIterator.next();
            ColumnCardsMap columnCardsMap = boardColumnsMap.get(columnKey);
            if(columnCardsMap.getColumnCardMap().containsKey(new CardItemKey(cardItem.getCardTitle()))){
                isCardFoundInAnyColumn = true;
                columnName = columnKey.getColumnName();
            }
        }
        if(isCardFoundInAnyColumn){
            return columnName;
        }else{
            throw new CardNotFoundException(cardItem, "any column");
        }
    }

    public Integer getIterationVelocity(){
        ColumnCardsMap columnCardsMap = boardColumnsMap.get(new ColumnKey(Constants.COLUMN_NAME_DONE));
        Set<CardItemKey> cardItemKeySet = columnCardsMap.getColumnCardMap().keySet();
        Iterator<CardItemKey> cardItemKeyIterator = cardItemKeySet.iterator();
        Integer iterationVelocity = 0;
        while (cardItemKeyIterator.hasNext()) {
            CardItemKey cardItemKey = cardItemKeyIterator.next();
            CardItemContent cardItemContent = columnCardsMap.getColumnCardMap().get(cardItemKey);
            iterationVelocity+=cardItemContent.getCardEstimate();
        }
        return iterationVelocity;
    }
}