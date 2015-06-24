package com.DLU.main;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class SchemaDefinition {

        String tableName = "customer";
        ArrayList<Column> columns = new ArrayList<Column>();


    public String getRowToInsert() {

        ArrayList<Integer> columnValues = generateInsertQueryValues();

        String columnNamesString = StringUtils.join(columnValues, ',');

        return String.format("insert into %s values(%s)",tableName,columnNamesString);

    }

    private ArrayList<Integer> generateInsertQueryValues() {

        ArrayList<Integer> columnValues = new ArrayList<Integer>();

        for(Column column:columns){

            int columnValue = column.getValue();
            columnValues.add(columnValue);

        }

        return columnValues;

    }
}

