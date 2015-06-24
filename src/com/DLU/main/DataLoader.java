package com.DLU.main;

import java.sql.*;

//Populates the database
public class DataLoader {

    public void populate(int numberOfRecordsToInsert) {

        QueryGenerator queryGenerator = new QueryGenerator(numberOfRecordsToInsert);

        Database database = Database.getInstance();

        try {

            Statement batch = queryGenerator.generateInsertBatch();

            database.executeBatchQuery(batch);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
