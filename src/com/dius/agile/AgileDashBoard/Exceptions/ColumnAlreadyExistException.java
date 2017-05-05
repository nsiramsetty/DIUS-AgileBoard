package com.dius.agile.AgileDashBoard.Exceptions;

/**
 * Created by nsiramsetty on 5/5/17.
 */
public class ColumnAlreadyExistException extends Exception {

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    private String columnName;

    public ColumnAlreadyExistException(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public void printStackTrace() {
        System.out.println("Column with name \""+columnName+"\" already exists in the agile board.");
    }
}