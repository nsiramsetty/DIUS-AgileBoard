package com.dius.agile.AgileDashBoard;

import com.dius.agile.AgileDashBoard.AgileBoard.Board;
import com.dius.agile.AgileDashBoard.Exceptions.ColumnNotFoundException;
import com.dius.agile.AgileDashBoard.IterationConstants.Constants;

/**
 * Created by nsiramsetty on 5/5/17.
 */
public class Main {

    public static void main(String args[]) throws ColumnNotFoundException {

        Board agileBoard=new Board();
        try{
            agileBoard.addColumn(Constants.COLUMN_NAME_NEW);
            agileBoard.addColumn(Constants.COLUMN_NAME_STARTING);
            agileBoard.addColumn(Constants.COLUMN_NAME_IN_PROGRESS);
            agileBoard.addColumn(Constants.COLUMN_NAME_DONE);
            agileBoard.addColumn(Constants.COLUMN_NAME_DONE);
        }catch (ColumnNotFoundException e){
            e.printStackTrace();
        }

    }
}