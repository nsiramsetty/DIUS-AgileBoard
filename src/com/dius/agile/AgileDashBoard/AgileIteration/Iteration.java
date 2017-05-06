package com.dius.agile.AgileDashBoard.AgileIteration;

import com.dius.agile.AgileDashBoard.AgileBoard.Board;
import com.dius.agile.AgileDashBoard.AgileCardItem.CardItem;
import com.dius.agile.AgileDashBoard.Exceptions.CardAlreadyExistsException;
import com.dius.agile.AgileDashBoard.Exceptions.CardNotFoundException;
import com.dius.agile.AgileDashBoard.Exceptions.ColumnNotFoundException;
import com.dius.agile.AgileDashBoard.Exceptions.WIPExceededException;
import com.dius.agile.AgileDashBoard.LastAction.Action;

/**
 * Created by nsiramsetty on 5/5/17.
 */
public class Iteration {
    public Board getAgileBoard() {
        return agileBoard;
    }

    public void setAgileBoard(Board agileBoard) {
        this.agileBoard = agileBoard;
    }

    public Action getLastAddAction() {
        return lastAddAction;
    }

    public void setLastAddAction(Action lastAddAction) {
        this.lastAddAction = lastAddAction;
    }

    public Action getLastMoveAction() {
        return lastMoveAction;
    }

    public void setLastMoveAction(Action lastMoveAction) {
        this.lastMoveAction = lastMoveAction;
    }

    public Action getLastRemoveAction() {
        return lastRemoveAction;
    }

    public void setLastRemoveAction(Action lastRemoveAction) {
        this.lastRemoveAction = lastRemoveAction;
    }

    private Board agileBoard;

    private Action lastAddAction;

    private Action lastMoveAction;

    private Action lastRemoveAction;

    public Iteration(Board agileBoard) {
        this.agileBoard = agileBoard;
        this.lastAddAction=new Action();
        this.lastMoveAction=new Action();
        this.lastRemoveAction=new Action();
    }

    public void add(CardItem cardItem, String columnName) throws ColumnNotFoundException,CardAlreadyExistsException,WIPExceededException{
        getAgileBoard().getColumnCardsMapByColumnKey(columnName).addCardItem(cardItem);
    }
}