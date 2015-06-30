package com.DLU.main;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class SchemaDefinition {


    private String tableName;
    private ArrayList<Column> columns = new ArrayList<Column>();
    private ArrayList<Constraint> constraints;
    private boolean columnHasConstraint = false;


    SchemaDefinition(String tableName, ArrayList<Column> columnInputs, ArrayList<Constraint> constraints) {

        this.tableName = tableName;
        this.columns = columnInputs;
        this.constraints = constraints;

    }


    public String getRowToInsert(int seed) {
        ArrayList columnValues = generateInsertQueryValues(seed);

        String columnNamesString = StringUtils.join(columnValues, ',');

        return String.format("insert into %s values(%s)",tableName,columnNamesString);

    }

    private ArrayList generateInsertQueryValues(int seed) {

        ArrayList columnValues = new ArrayList<Integer>();

        for(Column column:columns){

            columnHasConstraint = checkConstraint(column);

            if(columnHasConstraint){
                columnValues.add(column.getValue(seed));
            }

            else{
                columnValues.add(column.getValue());
            }

        }

        return columnValues;
    }


    private boolean checkConstraint(Column column){

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

