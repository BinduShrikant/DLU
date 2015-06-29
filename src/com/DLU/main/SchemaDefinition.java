package com.DLU.main;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class SchemaDefinition {


    private String tableName;
    private ArrayList<Column> columns = new ArrayList<Column>();
    private ArrayList<Constraint> constraints;
    private boolean columnHasConstraint = false;
    private static int rowCount =0;


    public SchemaDefinition(String tableName, ArrayList<Column> columnInputs,ArrayList<Constraint> constraints) {

        this.tableName = tableName;
        this.columns = columnInputs;

        this.constraints = constraints;

    }


    public String getRowToInsert() {

        ArrayList columnValues = generateInsertQueryValues();
        rowCount++;

        String columnNamesString = StringUtils.join(columnValues, ',');

        return String.format("insert into %s values(%s)",tableName,columnNamesString);

    }

    private ArrayList generateInsertQueryValues() {

        ArrayList columnValues = new ArrayList<Integer>();

        for(Column column:columns){

            columnHasConstraint = checkConstraint(column);

            if(columnHasConstraint){
                columnValues.add(column.getValue(rowCount));
            }

            else{
                columnValues.add(column.getValue());
            }

        }

        return columnValues;
    }


    public boolean checkConstraint(Column column){

        for(Constraint constraint:constraints){

            if((constraint.columnsWithConstraint)
                    .contains(column) && constraint.constraint == Constraints.compositeprimarykey){return true;}
            if((constraint.columnsWithConstraint)
                    .contains(column) && constraint.constraint == Constraints.primarykey){return true;}
            if((constraint.columnsWithConstraint)
                    .contains(column) && constraint.constraint == Constraints.uniquekey){return true;}

        }

        return false;

    }

}

