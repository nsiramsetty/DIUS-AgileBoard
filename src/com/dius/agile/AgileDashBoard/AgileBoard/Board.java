package com.dius.agile.AgileDashBoard.AgileBoard;

import com.dius.agile.AgileDashBoard.AgileColumns.ColumnCardsMap;
import com.dius.agile.AgileDashBoard.AgileColumns.ColumnKey;
import com.dius.agile.AgileDashBoard.Exceptions.ColumnNotFoundException;

import java.util.HashMap;

/**
 * Created by nsiramsetty on 5/5/17.
 */
public class Board {
    public Board(HashMap<ColumnKey, ColumnCardsMap> boardColumnsMap) {
        this.boardColumnsMap = boardColumnsMap;
    }

    public Board() {
        this.boardColumnsMap = new HashMap<>();
    }

    public void addColumn(String columnName) throws ColumnNotFoundException {
        ColumnKey columnKey=new ColumnKey(columnName);
        if(boardColumnsMap.containsKey(columnKey)){
            throw new ColumnNotFoundException(columnName);
        }else{
            ColumnCardsMap columnCardsMap=new ColumnCardsMap();
            boardColumnsMap.put(columnKey,columnCardsMap);
        }
    }

    public ColumnCardsMap getColumnCardsMapByColumnKey(String columnName) throws  ColumnNotFoundException{
        ColumnKey columnKey=new ColumnKey(columnName);
        if(!boardColumnsMap.containsKey(columnKey)){
            throw new ColumnNotFoundException(columnName);
        }else{
            return boardColumnsMap.get(columnKey);
        }
    }

    public HashMap<ColumnKey, ColumnCardsMap> getBoardColumnsMap() {
        return boardColumnsMap;
    }

    public void setBoardColumnsMap(HashMap<ColumnKey, ColumnCardsMap> boardColumnsMap) {
        this.boardColumnsMap = boardColumnsMap;
    }

    private HashMap<ColumnKey,ColumnCardsMap> boardColumnsMap;

}