package com.DLU.main;


import java.util.ArrayList;

public class Schema{


    private SchemaDefinition schemaDefinition;

    Schema(SchemaDefinition schemadefinition) {

        schemaDefinition = schemadefinition;
    }

    public ArrayList<String> getRowsToInsert(int numberOfRecordsToInsert) {

        String query;
        ArrayList<String> queryList = new ArrayList<String>();

        while (numberOfRecordsToInsert > 0) {

            query = schemaDefinition.getRowToInsert(queryList.size());
            queryList.add(query);

            numberOfRecordsToInsert = numberOfRecordsToInsert - 1;

        }

        return queryList;
    }



}
