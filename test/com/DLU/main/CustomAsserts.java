package com.DLU.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

//Custom assert methods for tests
public class CustomAsserts {


    public static void assertInsert(int load, int countOfCurrentEntries){

        assertEquals("This test verifies that all the values are present.", load, (testEntries() - countOfCurrentEntries));
    }

   /* public static void assertQuery(String query){

        assertEquals("It checks whether the the generated query is in proper format",query,);

    }*/

    public static int testEntries() {

        int check_count = 0;

        String query_count = "select count(*) from customer;";
        try {

            check_count = executeSelect(query_count);
        }
        catch (SQLException e){
            return check_count;
        }
        return check_count;

    }


    private static int executeSelect(String query) throws SQLException{

        int record_count=0;

        ResultSet count_entries;
        Database database = Database.getInstance();
        Connection dbCon = database.getConnection();

        Statement stmt = dbCon.createStatement();
        count_entries = stmt.executeQuery(query);
        record_count = getRecordCount(count_entries);

        return record_count;

    }


    private static int getRecordCount(ResultSet count_entries) throws SQLException {

        int check_count = 0;

        while (count_entries.next()) {
            check_count = count_entries.getInt(1);
        }
        return check_count;
    }
}