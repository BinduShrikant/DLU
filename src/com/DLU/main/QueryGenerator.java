package com.DLU.main;

import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.*;

//Generates the batch of query
public class QueryGenerator {

    private int numberOfRecordsToInsert;

    QueryGenerator(int load) {
        numberOfRecordsToInsert = load;
    }

    public Statement generateInsertBatch(Schema schema) throws SQLException {

        Database database = Database.getInstance();

        Connection dbCon = null;
        dbCon = database.getConnection();
        Statement stmt = dbCon.createStatement();

        ArrayList<String> queryList = schema.getRowsToInsert(numberOfRecordsToInsert);

            for(String query : queryList) {
                 stmt.addBatch(query);
            }

        return stmt;
    }

}




