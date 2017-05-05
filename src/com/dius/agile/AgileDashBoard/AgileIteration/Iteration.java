package com.dius.agile.AgileDashBoard.AgileIteration;

import com.dius.agile.AgileDashBoard.AgileBoard.Board;
import com.dius.agile.AgileDashBoard.LastAction.Action;

/**
 * Created by nsiramsetty on 5/5/17.
 */
public class Iteration {
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
}
