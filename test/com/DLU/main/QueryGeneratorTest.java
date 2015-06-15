package com.DLU.main;


//tests the QueryGenerator class
import org.junit.Test;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryGeneratorTest {

    @Test
    public void testgenerateBatch() throws SQLException {

      int numberOfRecordsToInsert = 1;
      QueryGenerator querygenerator = new QueryGenerator(numberOfRecordsToInsert);

      Statement batch = querygenerator.generateInsertBatch(numberOfRecordsToInsert);
      int countOfQueries= batch.getUpdateCount();
        System.out.println(countOfQueries);

      assertEquals("It checks whether the required number of queries are batched", 1, countOfQueries);
  }





}