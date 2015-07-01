package com.DLU.main;

import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.Assert.*;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.DLU.main.CustomAsserts.*;

//Test the DataLoader class
public class DataLoaderTest {

    @Test
    public void testThatADataLoaderPopulatesTheRequestedDataVolume() throws SQLException{

        DataLoader dataLoader = new DataLoader();
        int load = 10;

        int countOfCurrentEntries = testEntries();

        dataLoader.populate(load);

        assertInsert(load, countOfCurrentEntries);

        Database database=Database.getInstance();
        database.cleanDatabase(load);
    }


    @Test
    public void testThatADataLoaderDoesNotPopulatesTheDataVolumeWhenLoadCrossesLimit() throws SQLException{

        DataLoader dataLoader = new DataLoader();
        int load = 50001;

        int countOfCurrentEntries = testEntries();

        assertEquals(-1,dataLoader.populate(load));

        assertEquals(countOfCurrentEntries,testEntries());

    }


    @Test
    public void testThatADataLoaderDoesNotPopulatesTheDataVolumeWhenLoadIsNegative() throws SQLException{

        DataLoader dataLoader = new DataLoader();
        int load = -21;

        int countOfCurrentEntries = testEntries();


        assertEquals(-1,dataLoader.populate(load));

        assertEquals(countOfCurrentEntries,testEntries());

    }

}
