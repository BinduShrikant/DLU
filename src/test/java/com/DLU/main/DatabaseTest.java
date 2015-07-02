package com.DLU.main;

import com.DLU.main.Database;
import org.junit.Test;

import java.util.ArrayList;


public class DatabaseTest {

    @Test
    public void testExecuteBatchQueryInsertsAllRecords() throws Exception {

        int load = 2;
        int countOfCurrentEntries = CustomAsserts.testEntries();
        ArrayList<String> queryList=new ArrayList<String>();
        Database database=Database.getInstance();
        DataLoader dataLoader = new DataLoader();

        queryList.add("insert into customer values(111,111,\"bindu\",\"bindu@.com\",\"2015-2-2\")");
        queryList.add("insert into customer values(222,222,\"bindu1\",\"bindu1@.com\",\"2015-2-2\")");
        database.executeBatchQuery(queryList);

        CustomAsserts.assertInsert(load, countOfCurrentEntries);

        dataLoader.cleanDatabase(load);

    }


    @Test
    public void testExecuteBatchQueryDoesNotInsertAnyRecordsWhenThereIsAFailure() throws Exception {

        Database database = Database.getInstance();
        ArrayList<String> queryList=new ArrayList<String>();
        int countOfCurrentEntries = CustomAsserts.testEntries();

        queryList.add("insert into customer values(333,333,\"bindu3\",\"bindu3@.com\",\"2015-2-2\")");
        queryList.add("insert into customer values(444,@#,\"bindu\",\"bindu@.com\",\"2015-2-2\")");
        database.executeBatchQuery(queryList);

        CustomAsserts.assertInsert(0, countOfCurrentEntries);
    }


}