package com.DLU.main;


import java.util.ArrayList;

public class Schema {

    ArrayList<String> queryList = new ArrayList<String>();
    SchemaDefinition schema =new SchemaDefinition();
    Column column=new Column();


   public SchemaDefinition getSchema(){

       schema.tableName="customer";
       column.ColumnName="id";
       column.Datatype="int";
       (schema.columns).add(column);
       column.ColumnName="name";
       column.Datatype="String";
       (schema.columns).add(column);


       return schema;
   }

    public ArrayList<String> getRowsToInsert(int numberOfRecordsToInsert){

        String query;

        while(numberOfRecordsToInsert>0){
            System.out.println(schema);
             query =schema.getRowToInsert();
             queryList.add(query);

            numberOfRecordsToInsert = numberOfRecordsToInsert - 1;

        }

        return queryList;
    }

}
