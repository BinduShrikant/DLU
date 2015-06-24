package com.DLU.main;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.junit.Test;
import static com.DLU.main.CustomAsserts.*;

//Testa the DataLoader class
public class DataLoaderTest {

    @Test
    public void testThatADataLoaderPopulatesTheRequestedDataVolume() {

        DataLoader dataLoader = new DataLoader();
        int load = 10;

        int countOfCurrentEntries = testEntries();

        dataLoader.populate(load);

        assertInsert(load, countOfCurrentEntries);
    }



}
