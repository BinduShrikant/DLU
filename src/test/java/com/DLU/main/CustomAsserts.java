package com.DLU.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

//Custom assert methods for tests
public class CustomAsserts {


    public static void assertInsert(int load, int countOfCurrentEntries){

        assertEquals("This test verifies that all the values are present.", load, (testEntries() - countOfCurrentEntries));
    }


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

    public static void assertQueryPattern(String pattern,String query){

        Pattern insertQueryPattern = Pattern.compile(pattern);

        Matcher insertQueryMatch = insertQueryPattern.matcher(query);

        assertEquals("This test assures that the insert query is in correct format",true,insertQueryMatch.find());

    }


    private static int executeSelect(String query) throws SQLException{

        int record_count=0;

        ResultSet count_entries;
        Database database = Database.getInstance("jdbc:h2:mem:cust;MODE=MYSQL", "org.h2.Driver", "root", "");
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