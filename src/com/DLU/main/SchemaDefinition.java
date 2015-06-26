package com.DLU.main;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class SchemaDefinition {


    private String tableName;
    private ArrayList<Column> columns = new ArrayList<Column>();
    private Constraint constraint;


    public SchemaDefinition(String tableName, ArrayList<Column> columnInputs,ArrayList<Constraint> listOfConstraints) {

        this.tableName = tableName;
        this.columns = columnInputs;
        constraint = new Constraint(listOfConstraints);

    }


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

