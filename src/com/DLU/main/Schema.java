package com.DLU.main;


import java.util.ArrayList;

//generate insert list of queries
public class Schema{


    private SchemaDefinition schemaDefinition;

    Schema(String tableName, ArrayList<Column> columnInputs) {

        //constructor to schemadefinition can be called here to remove inheritance
        schemaDefinition = new SchemaDefinition(tableName,columnInputs);

    }

    public ArrayList<String> getRowsToInsert(int numberOfRecordsToInsert) {

        String query;
        ArrayList<String> queryList = new ArrayList<String>();

        while (numberOfRecordsToInsert > 0) {

            query = schemaDefinition.getRowToInsert();
            queryList.add(query);

            numberOfRecordsToInsert = numberOfRecordsToInsert - 1;

        }

        return queryList;
    }

}
