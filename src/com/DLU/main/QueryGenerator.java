package com.DLU.main;

import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.*;

//Generates the query based on the request
public class QueryGenerator {

    private int numberOfRecordsToInsert;


    QueryGenerator(int load) {

        numberOfRecordsToInsert = load;

    }

    //TODO : remove the unnecessary connection we have in query generator
    public Statement generateInsertBatch() throws SQLException {

        Database database = Database.getInstance();
        String tablename = "customer";

        Connection dbCon = null;
        dbCon = database.getConnection();
        Statement stmt = dbCon.createStatement();

        while (numberOfRecordsToInsert > 0) {

            String query = generateInsertQuery(tablename);
            stmt.addBatch(query);

            numberOfRecordsToInsert = numberOfRecordsToInsert - 1;
        }

        return stmt;
    }


    private String generateInsertQuery(String tablename) throws SQLException {

        ArrayList<String> columns = generateInsertQueryValues();

        String columnNamesString = StringUtils.join(columns, ',');

        return String.format("insert into %s values(%s)", tablename, columnNamesString);


    }

    private ArrayList<String> generateInsertQueryValues() {

        SchemaGenerator schemagenerator = new SchemaGenerator();
        Map<String, List<String>> schema;
        schema = schemagenerator.generateTheSchemaOfTheDatabaseTable();

        ArrayList<String> columns = new ArrayList<String>();


        long randomValue = System.nanoTime();
        randomValue = randomValue/1000;
        randomValue = randomValue%1000000000;


        for (Map.Entry<String, List<String>> entry : schema.entrySet()) {

            List<String> valueList = entry.getValue();

            if (valueList.get(1).compareTo("primary key") == 0
                    || valueList.get(1).compareTo("composite primary key") == 0
                    || valueList.get(1).compareTo("unique key") == 0) {

                columns.add(String.valueOf(randomValue));

            } else if (valueList.get(1).compareTo("Null") == 0) {

                columns.add(String.valueOf(randomValue));
            }
        }
        return columns;

    }

}




