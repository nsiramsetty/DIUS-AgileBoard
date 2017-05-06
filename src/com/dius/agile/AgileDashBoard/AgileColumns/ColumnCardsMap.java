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

    public void addCardItem(CardItem cardItem) throws CardAlreadyExistsException,WIPExceededException{
        CardItemKey cardItemKey=new CardItemKey(cardItem.getCardTitle());
        if(columnCardMap.containsKey(cardItemKey)){
            throw new CardAlreadyExistsException(cardItem);
        }else{
            Integer iterationPointsCount = getIterationPointsCount()+cardItem.getCardEstimate();
            if(iterationPointsCount > Constants.WIP_LIMIT){
                throw new WIPExceededException(cardItem,iterationPointsCount);
            }else{
                CardItemContent cardItemContent=new CardItemContent(cardItem.getCardDescription(),cardItem.getCardEstimate());
                columnCardMap.put(cardItemKey,cardItemContent);
            }
        }
    }

    public void removeCardItem(CardItem cardItem) throws CardNotFoundException{
        CardItemKey cardItemKey=new CardItemKey(cardItem.getCardTitle());
        if(!columnCardMap.containsKey(cardItemKey)){
            throw new CardNotFoundException(cardItem);
        }else{
            columnCardMap.remove(cardItemKey);
        }
    }

    public Integer getIterationPointsCount(){
        Set<CardItemKey> cardItemKeySet = columnCardMap.keySet();
        Iterator<CardItemKey> cardItemKeyIterator=cardItemKeySet.iterator();
        Integer iterationPointsCount=0;
        while(cardItemKeyIterator.hasNext()){
            iterationPointsCount+=columnCardMap.get(cardItemKeyIterator.next()).getCardEstimate();
        }
        return iterationPointsCount;
    }
}