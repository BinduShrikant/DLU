package com.DLU.main;

import java.sql.*;

//Populates the database
public class DataLoader {

    public void populate(int numberOfRecordsToInsert) {

        QueryGenerator queryGenerator = new QueryGenerator(numberOfRecordsToInsert);

        Database database = new Database();

        try {
            Statement batch = queryGenerator.generateInsertBatch(numberOfRecordsToInsert);

            database.executeBatchQuery(batch);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
