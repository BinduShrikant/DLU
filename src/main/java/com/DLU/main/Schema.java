package com.DLU.main;


import java.util.ArrayList;

public class Schema{


    private SchemaDefinition schemaDefinition;

    Schema(SchemaDefinition schemadefinition) {

        schemaDefinition = schemadefinition;
    }

    public <T> T getRowsToInsert(int numberOfRecordsToInsert) {

        String query;
        ArrayList<String> queryList = new ArrayList<String>();

        if(numberOfRecordsToInsert<50001 && numberOfRecordsToInsert>0) {

            while (numberOfRecordsToInsert > 0) {

                query = schemaDefinition.getRowToInsert(queryList.size());
                queryList.add(query);

                numberOfRecordsToInsert = numberOfRecordsToInsert - 1;
            }

            return (T) new ArrayList<String>(queryList);
    }
    else {

        System.out.println("Limit [0-50000]");

        return (T) new Integer(-1);

        }
    }



}
