package com.DLU.main;

import org.junit.Test;
import static com.DLU.main.CustomAsserts.*;

//Testa the DataLoader class
public class DataLoaderTest {

    @Test
    public void testThatADataLoaderPopulatesTheRequestedDataVolume() {

        DataLoader dataLoader = new DataLoader();
        int load = 1000;

        int countOfCurrentEntries = testEntries();

        dataLoader.populate(load);

        assertInsert(load, countOfCurrentEntries);
    }



}
