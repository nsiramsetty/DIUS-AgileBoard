package com.dius.agile.AgileDashBoard.Exceptions;

/**
 * Created by nsiramsetty on 5/5/17.
 */
public class ColumnNotFoundException extends Exception {

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    private String columnName;

    public ColumnNotFoundException(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public void printStackTrace() {
        System.out.println("Column with name \""+columnName+"\" not found in the agile board.");
    }
}