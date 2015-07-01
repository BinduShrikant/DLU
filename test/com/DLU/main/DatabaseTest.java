package com.DLU.main;

import org.junit.Test;
import java.sql.*;
import java.util.ArrayList;

import static com.DLU.main.CustomAsserts.*;



public class DatabaseTest {

    @Test
    public void testExecuteBatchQueryInsertsAllRecords() throws Exception {

        int load = 2;
        int countOfCurrentEntries = testEntries();
        ArrayList<String> queryList=new ArrayList<String>();
        Database database=Database.getInstance();

        queryList.add("insert into customer values(111,111,\"bindu\",\"bindu@.com\",\"2015-2-2\")");
        queryList.add("insert into customer values(222,222,\"bindu1\",\"bindu1@.com\",\"2015-2-2\")");
        database.executeBatchQuery(queryList);

        assertInsert(load, countOfCurrentEntries);

        database.cleanDatabase(load);

    }


    @Test
    public void testExecuteBatchQueryDoesNotInsertAnyRecordsWhenThereIsAFailure() throws Exception {

        Database database = Database.getInstance();
        ArrayList<String> queryList=new ArrayList<String>();
        int countOfCurrentEntries = testEntries();

        queryList.add("insert into customer values(333,333,\"bindu3\",\"bindu3@.com\",\"2015-2-2\")");
        queryList.add("insert into customer values(444,@#,\"bindu\",\"bindu@.com\",\"2015-2-2\")");
        database.executeBatchQuery(queryList);

        assertInsert(0, countOfCurrentEntries);
    }

    @Test
    public void testCleanDatabaseDeletesAllTheEntriesGeneratedByDLU() throws Exception {

        Database database = Database.getInstance();
        ArrayList<String> queryList=new ArrayList<String>();
        int countOfCurrentEntries = testEntries();

        queryList.add("insert into customer values(111,111,\"bindu\",\"bindu@.com\",\"2015-2-2\")");
        queryList.add("insert into customer values(222,222,\"bindu1\",\"bindu1@.com\",\"2015-2-2\")");
        database.executeBatchQuery(queryList);

        database.cleanDatabase(2);

        assertInsert(0, countOfCurrentEntries);
    }
}