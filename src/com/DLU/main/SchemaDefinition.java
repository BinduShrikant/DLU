package com.DLU.main;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SchemaDefinition {

        String tableName = "customer";
        ArrayList<Column> columns = new ArrayList<Column>();
/*
        ArrayList<List<Constraints>> constraints;

    public enum Constraints {
        primarykey,
        compositeprimarykey,
        uniquekey
    }
*/

    public String getRowToInsert() {

        ArrayList<Integer> columnValues = generateInsertQueryValues();

        String columnNamesString = StringUtils.join(columnValues, ',');

        return String.format("insert into %s values(%s)",tableName,columnNamesString);

    }

    private ArrayList<Integer> generateInsertQueryValues() {

        ArrayList<Integer> columnValues = new ArrayList<Integer>();
       // Schema Schemaobj=new Schema();
        SchemaDefinition schema=new Schema().getSchema();

        for(Column column:schema.columns){

            int columnValue = column.getValue();
            columnValues.add(columnValue);
        }

        return columnValues;

    }
}

