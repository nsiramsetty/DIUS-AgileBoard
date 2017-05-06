/**
 * Created by Naresh Siramsetty on 6/5/17.
 */

package com.dius.agile.DashBoardInterface;

import com.dius.agile.DashBoardImpl.CardItem.CardItem;

public interface IterationInterface {

    public void add(CardItem cardItem);

    public void move(CardItem cardItem,String columnName);

    public void undoLastMove();

    public void printVelocity();

    public void printBoard();

}