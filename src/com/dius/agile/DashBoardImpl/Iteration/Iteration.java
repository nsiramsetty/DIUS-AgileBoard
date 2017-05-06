/**
 * Created by Naresh Siramsetty on 5/5/17.
 */

package com.dius.agile.DashBoardImpl.Iteration;

import com.dius.agile.DashBoardImpl.Action.Action;
import com.dius.agile.DashBoardImpl.Board.Board;
import com.dius.agile.DashBoardImpl.CardItem.CardItem;
import com.dius.agile.DashBoardImpl.Constants.Constants;
import com.dius.agile.DashBoardImpl.Exceptions.CardAlreadyExistsException;
import com.dius.agile.DashBoardImpl.Exceptions.CardNotFoundException;
import com.dius.agile.DashBoardImpl.Exceptions.ColumnNotFoundException;
import com.dius.agile.DashBoardImpl.Exceptions.WIPExceededException;
import com.dius.agile.DashBoardInterface.IterationInterface;

public class Iteration implements IterationInterface{
    private Board agileBoard;
    private Action lastMoveAction;


    public Iteration(Board agileBoard) {
        this.agileBoard = agileBoard;
        this.lastMoveAction = new Action();
    }

    private Board getAgileBoard() {
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

    private void addCardItem(CardItem cardItem, String toColumnName) {
        try {
            if (getAgileBoard().canAddCardItem(cardItem, toColumnName)) {
                getAgileBoard().addCardItem(cardItem, toColumnName);
            }
        } catch (ColumnNotFoundException cnfException) {
            cnfException.printStackTrace();
        } catch (CardAlreadyExistsException caeException) {
            caeException.printStackTrace();
        } catch (WIPExceededException wipException) {
            wipException.printStackTrace();
        }
    }

    private void moveCardItem(CardItem cardItem, String fromColumnName, String toColumnName) {
        try {
            if (getAgileBoard().canAddCardItem(cardItem, toColumnName)) {
                getAgileBoard().addCardItem(cardItem, toColumnName);
                getAgileBoard().removeCardItem(cardItem, fromColumnName);
                getLastMoveAction().setCardItem(cardItem);
                getLastMoveAction().setToColumnName(toColumnName);
                getLastMoveAction().setFromColumnName(fromColumnName);
            }
        } catch (ColumnNotFoundException cnfException) {
            cnfException.printStackTrace();
        } catch (CardAlreadyExistsException caeException) {
            caeException.printStackTrace();
        } catch (CardNotFoundException cnfException) {
            cnfException.printStackTrace();
        } catch (WIPExceededException wipException) {
            wipException.printStackTrace();
        }
    }

    public void add(CardItem cardItem) {
        addCardItem(cardItem, Constants.COLUMN_NAME_NEW);
    }

    public void move(CardItem cardItem, String toColumnName) {
        try {
            String fromColumnName = getAgileBoard().getCardItemColumn(cardItem);
            moveCardItem(cardItem, fromColumnName, toColumnName);
        } catch (CardNotFoundException cnfException) {
            cnfException.printStackTrace();
        }
    }
    public void undoLastMove() {
        try {
            String fromColumnName = getAgileBoard().getCardItemColumn(getLastMoveAction().getCardItem());
            moveCardItem(getLastMoveAction().getCardItem(), getLastMoveAction().getToColumnName(), getLastMoveAction().getFromColumnName());
        } catch (CardNotFoundException cnfException) {
            cnfException.printStackTrace();
        }
    }

    public void printBoard() {
        getAgileBoard().printBoard();
    }

    public void printVelocity(){
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("------------------------------- Iteration  Velocity : "+ getAgileBoard().getIterationVelocity()+ " ------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
}