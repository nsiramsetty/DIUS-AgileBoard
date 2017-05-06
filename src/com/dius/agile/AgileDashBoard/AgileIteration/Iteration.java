/**
 * Created by Naresh Siramsetty on 5/5/17.
 */

package com.dius.agile.AgileDashBoard.AgileIteration;

import com.dius.agile.AgileDashBoard.AgileBoard.Board;
import com.dius.agile.AgileDashBoard.AgileCardItem.CardItem;
import com.dius.agile.AgileDashBoard.Exceptions.CardAlreadyExistsException;
import com.dius.agile.AgileDashBoard.Exceptions.ColumnNotFoundException;
import com.dius.agile.AgileDashBoard.Exceptions.WIPExceededException;
import com.dius.agile.AgileDashBoard.IterationConstants.Constants;
import com.dius.agile.AgileDashBoard.LastAction.Action;

public class Iteration {
    public Board getAgileBoard() {
        return agileBoard;
    }

    public void setAgileBoard(Board agileBoard) {
        this.agileBoard = agileBoard;
    }


    public Action getLastMoveAction() {
        return lastMoveAction;
    }

    public void setLastMoveAction(Action lastMoveAction) {
        this.lastMoveAction = lastMoveAction;
    }


    private Board agileBoard;

    private Action lastMoveAction;

    public Iteration(Board agileBoard) {
        this.agileBoard = agileBoard;
        this.lastMoveAction = new Action();
    }

    public void addCardItem(CardItem cardItem, String columnName)  {
        try{
            if(getAgileBoard().canAddCardItem(cardItem,columnName)){
                getAgileBoard().addCardItem(cardItem,columnName);
            }
        }catch(ColumnNotFoundException cnfException){
            cnfException.printStackTrace();
        }
        catch(CardAlreadyExistsException caeException){
            caeException.printStackTrace();
        }
        catch(WIPExceededException wipException){
            wipException.printStackTrace();
        }
    }

    public void add(CardItem cardItem){
        addCardItem(cardItem,Constants.COLUMN_NAME_NEW);
    }

    public void print(){
        agileBoard.printBoard();
    }
}