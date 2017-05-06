/**
 * Created by Naresh Siramsetty on 5/5/17.
 */

package com.dius.agile.DashBoardImpl.Columns;

public class ColumnKey {
    private String columnName;

    public ColumnKey(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColumnKey columnKey = (ColumnKey) o;

        return columnName.equals(columnKey.columnName);

    }

    @Override
    public int hashCode() {
        return columnName.hashCode();
    }
}