package com.DLU.main;

import org.junit.Test;
import java.sql.*;
import static com.DLU.main.CustomAsserts.*;



public class DatabaseTest {

    @Test
    public void testExecuteBatchQuery() throws Exception {

        Database database = new Database();
        Connection dbCon = null;

        dbCon = database.getConnection();
        Statement stmt = dbCon.createStatement();


        int load = 2;
        int countOfCurrentEntries = testEntries();

        stmt.addBatch("insert into customer values(1,1,\"bindu\",\"bindu@gmail.com\")");
        stmt.addBatch("insert into customer values(2,2,\"bindu1\",\"bindu1@gmail.com\")");
        database.executeBatchQuery(stmt);

        assertInsert(load, countOfCurrentEntries);
    }


    @Test
    public void testExecuteBatchQueryDoesNotInsertAnyRecordsWhenThereIsAFailure() throws Exception {

        Database database = new Database();
        Connection dbCon = null;

        dbCon = database.getConnection();
        dbCon.setAutoCommit(false);
        Statement stmt = dbCon.createStatement();

        int countOfCurrentEntries = testEntries();
        stmt.addBatch("insert into customer values(12,12,\"bindu3\",\"bindu3@gmail.com\")");
        stmt.addBatch("insert into customer values(1,@#,\"bindu\",\"bindu@gmail.com\")");
        database.executeBatchQuery(stmt);

        assertInsert(0, countOfCurrentEntries);
    }
}