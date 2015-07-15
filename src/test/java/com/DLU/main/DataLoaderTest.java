package com.DLU.main;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//Test the DataLoader class
public class DataLoaderTest {

    private static Database database;
    private static DataLoader dataLoader;

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
    public void testThatADataLoaderPopulatesTheRequestedDataVolume() throws Exception {

        int load = 10;

        int countOfCurrentEntries = CustomAsserts.testEntries();

        dataLoader.populate(load);

        CustomAsserts.assertInsert(load, countOfCurrentEntries);

        dataLoader.cleanDatabase(load);
    }


    @Test
    public void testCleanDatabaseDeletesAllTheEntriesGeneratedByDLU() throws Exception {
        ArrayList<String> queryList=new ArrayList<String>();
        int countOfCurrentEntries = CustomAsserts.testEntries();

        queryList.add("insert into customer values(111,111,'bindu','bindu@.com','2015-2-2')");
        queryList.add("insert into customer values(222,222,'bindu1','bindu1@.com','2015-2-2')");
        database.executeBatchQuery(queryList);

        dataLoader.cleanDatabase(2);

        CustomAsserts.assertInsert(0, countOfCurrentEntries);
    }

}
