package com.DLU.main;

import java.sql.*;

//Populates the database
public class DataLoader {

    private final Database database;

    public DataLoader() {
        database = new Database();
    }


    public void populate(int numberOfRecordsToInsert) {

        try {
            database.executeBatchQuery(numberOfRecordsToInsert);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
