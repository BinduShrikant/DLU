package com.DLU.main;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseTest {

    private static Database database;
    private static DataLoader dataLoader;

    private int countOfCurrentEntries = CustomAsserts.testEntries();
    private ArrayList<String> queryList=new ArrayList<String>();

    @BeforeClass
    public static void setup() throws SQLException {
        dataLoader = new DataLoader("jdbc:h2:mem:cust;MODE=MYSQL", "org.h2.Driver", "root", "");
        database = Database.getInstance("jdbc:h2:mem:cust;MODE=MYSQL", "org.h2.Driver", "root", "");
        SampleDataBuilder.createCustomerTable(database);
    }

    @AfterClass
    public static void tearDown() throws SQLException {
        SampleDataBuilder.cleanup(database);
    }

    @Test
    public void testExecuteBatchQueryInsertsAllRecords() throws Exception {

        int load = 2;

        queryList.add("insert into customer values(111,111,'bindu','bindu@.com','2015-2-2')");
        queryList.add("insert into customer values(222,222,'bindu1','bindu1@.com','2015-2-2')");
        database.executeBatchQuery(queryList);

        CustomAsserts.assertInsert(load, countOfCurrentEntries);

        dataLoader.cleanDatabase(load);

    }


    @Test
    public void testExecuteBatchQueryDoesNotInsertAnyRecordsWhenThereIsAFailure() throws Exception {

        queryList.add("insert into customer values(333,333,'bindu3','bindu3@.com','2015-2-2')");
        queryList.add("insert into customer values(444,@#,'bindu','bindu@.com','2015-2-2')");
        database.executeBatchQuery(queryList);

        CustomAsserts.assertInsert(0, countOfCurrentEntries);
    }


}