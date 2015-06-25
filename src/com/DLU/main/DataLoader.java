package com.DLU.main;

import java.sql.*;
import java.util.ArrayList;

//Populates the database
public class DataLoader {

    public void populate(int numberOfRecordsToInsert) {

        QueryGenerator queryGenerator = new QueryGenerator(numberOfRecordsToInsert);

        String tableName = "customer";
        ArrayList<Column> columnInputs = new ArrayList<Column>();

        Database database = Database.getInstance();

        try {


            Column column1 = new Column("id","int");
            columnInputs.add(column1);

            Column column2 = new Column("name","String");
            columnInputs.add(column2);

            Schema schema=new Schema(tableName,columnInputs);

            Statement batch = queryGenerator.generateInsertBatch(schema);

            database.executeBatchQuery(batch);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
