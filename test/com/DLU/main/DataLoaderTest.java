package com.DLU.main;


import org.junit.Test;

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



}
