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

        Schema schema=new Schema();

      Statement batch = querygenerator.generateInsertBatch(schema);
      int countOfQueries[] = batch.executeBatch();

      assertEquals("It checks whether the required number of queries are batched", 1, countOfQueries[0]);
  }

}
