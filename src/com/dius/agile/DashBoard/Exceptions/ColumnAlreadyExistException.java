/**
 * Created by Naresh Siramsetty on 5/5/17.
 */

package com.dius.agile.DashBoard.Exceptions;

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
        System.out.println("Exception : Column with name \""
                + columnName + "\" already exists in the agile board.");
    }
}