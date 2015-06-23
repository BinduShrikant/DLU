package com.DLU.main;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class Schema {
    private final String tableName;
    private final ArrayList<Column> columns;

    public Schema(String tableName, ArrayList<Column> columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    public String getRowToInsert() {
        ArrayList<String> columnValues = new ArrayList<String>();

        for(Column column: columns){
            String columnValue = column.getValue();
            columnValues.add(columnValue);
        }

        return StringUtils.join(columnValues, ',');
    }
}

