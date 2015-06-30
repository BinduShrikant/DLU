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

    public ArrayList<String> generateInsertQueries(Schema schema) throws SQLException {

        return schema.getRowsToInsert(numberOfRecordsToInsert);

    }

}


