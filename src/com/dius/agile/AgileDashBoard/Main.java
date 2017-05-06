/**
 * Created by Naresh Siramsetty on 5/5/17.
 */

package com.dius.agile.AgileDashBoard;

import com.dius.agile.AgileDashBoard.AgileBoard.Board;
import com.dius.agile.AgileDashBoard.AgileCardItem.CardItem;
import com.dius.agile.AgileDashBoard.AgileIteration.Iteration;
import com.dius.agile.AgileDashBoard.IterationConstants.Constants;

import java.util.Iterator;

public class Main {

    public static void main(String args[]){

        // Creating an empty Board.
        Board agileBoard=new Board();
        // Adding Columns to the Board. This will add ColumnKey and the empty ColumnCards Map
        agileBoard.addColumn(Constants.COLUMN_NAME_NEW);
        agileBoard.addColumn(Constants.COLUMN_NAME_STARTING);
        agileBoard.addColumn(Constants.COLUMN_NAME_IN_PROGRESS);
        agileBoard.addColumn(Constants.COLUMN_NAME_DONE);
        // This should throw ColumnAlreadyExistException
        agileBoard.addColumn(Constants.COLUMN_NAME_DONE);
        // Start Iteration with the agileBoard
        Iteration agileIteration = new Iteration(agileBoard);
        // As of now, there were no CardItems in Board
        agileIteration.print();
        // Create Cards.
        CardItem cardItem01 = new CardItem("Title 01", "Description 01",5);
        CardItem cardItem02 = new CardItem("Title 02", "Description 02",10);
        CardItem cardItem03 = new CardItem("Title 03", "Description 03",15);
        CardItem cardItem04 = new CardItem("Title 04", "Description 04",20);
        CardItem cardItem05 = new CardItem("Title 05", "Description 05",25);
        CardItem cardItem06 = new CardItem("Title 06", "Description 06",25);
        CardItem cardItem07 = new CardItem("Title 07", "Description 07",25);
        CardItem cardItem08 = new CardItem("Title 08", "Description 08",0);
        CardItem cardItem09 = new CardItem("Title 08", "Description 09",0);
        // Start adding CardItems to Iteration. This will add CardItems to "New" Column by Default
        agileIteration.add(cardItem01); // Added
        agileIteration.add(cardItem02); // Added
        agileIteration.add(cardItem03); // Added
        agileIteration.add(cardItem04); // Added
        agileIteration.add(cardItem05); // Added
        agileIteration.add(cardItem06); // Added
        // This should throw WIPExceededException as WIP Limit set to 100 which has already reached.
        agileIteration.add(cardItem07);
        agileIteration.add(cardItem08); // Should get added as the Estimate is 0
        // This should throw CardAlreadyExistsException as CardItem with Title 07 already Exists
        agileIteration.add(cardItem09);
        // Lets have a look at the CardItems added. Card Items 7 & 9 were not added due to exceptions.
        agileIteration.print();
    }
}