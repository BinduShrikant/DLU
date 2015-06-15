package com.DLU.main;

import java.sql.*;

//Populates the database
public class DataLoader {

    public void populate(int numberOfRecordsToInsert) {
         QueryGenerator queryGenerator=new QueryGenerator(numberOfRecordsToInsert);

        try {
            queryGenerator.generateInsertBatch(numberOfRecordsToInsert);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
