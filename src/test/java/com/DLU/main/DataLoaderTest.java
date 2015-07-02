package com.DLU.main;

import com.DLU.main.DataLoader;
import com.DLU.main.Database;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

//Test the DataLoader class
public class DataLoaderTest {

    @Test
    public void testThatADataLoaderPopulatesTheRequestedDataVolume() throws SQLException{

        DataLoader dataLoader = new DataLoader();
        int load = 10;

        int countOfCurrentEntries = CustomAsserts.testEntries();

        dataLoader.populate(load);

        CustomAsserts.assertInsert(load, countOfCurrentEntries);

        dataLoader.cleanDatabase(load);
    }


    @Test
    public void testThatADataLoaderDoesNotPopulatesTheDataVolumeWhenLoadCrossesLimit() throws SQLException{

        DataLoader dataLoader = new DataLoader();
        int load = 50001;

        int countOfCurrentEntries = CustomAsserts.testEntries();

        Assert.assertEquals(-1, dataLoader.populate(load));

        Assert.assertEquals(countOfCurrentEntries, CustomAsserts.testEntries());

    }


    @Test
    public void testThatADataLoaderDoesNotPopulatesTheDataVolumeWhenLoadIsNegative() throws SQLException{

        DataLoader dataLoader = new DataLoader();
        int load = -21;

        int countOfCurrentEntries = CustomAsserts.testEntries();


        Assert.assertEquals(-1, dataLoader.populate(load));

        Assert.assertEquals(countOfCurrentEntries, CustomAsserts.testEntries());

    }

    @Test
    public void testCleanDatabaseDeletesAllTheEntriesGeneratedByDLU() throws Exception {

        Database database = Database.getInstance();
        DataLoader dataLoader = new DataLoader();
        ArrayList<String> queryList=new ArrayList<String>();
        int countOfCurrentEntries = CustomAsserts.testEntries();

        queryList.add("insert into customer values(111,111,\"bindu\",\"bindu@.com\",\"2015-2-2\")");
        queryList.add("insert into customer values(222,222,\"bindu1\",\"bindu1@.com\",\"2015-2-2\")");
        database.executeBatchQuery(queryList);

        dataLoader.cleanDatabase(2);

        CustomAsserts.assertInsert(0, countOfCurrentEntries);
    }

}
