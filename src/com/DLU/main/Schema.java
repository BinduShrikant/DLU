package com.DLU.main;


import java.util.ArrayList;

public class Schema extends SchemaDefinition {

    ArrayList<String> queryList = new ArrayList<String>();

    Column column = new Column();

    Schema() {

        this.tableName = "customer";
        column.ColumnName = "id";
        column.Datatype = "int";
        (this.columns).add(column);
        column.ColumnName = "name";
        column.Datatype = "String";
        (this.columns).add(column);

    }

    public ArrayList<String> getRowsToInsert(int numberOfRecordsToInsert) {

        String query;

        while (numberOfRecordsToInsert > 0) {

            query = getRowToInsert();
            queryList.add(query);

            numberOfRecordsToInsert = numberOfRecordsToInsert - 1;

        }

        return queryList;
    }

}
