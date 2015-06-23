package com.DLU.main;


//tests the QueryGenerator class
import org.junit.Test;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryGeneratorTest {

    @Test
    public void testgenerateBatch() throws SQLException {

      int numberOfRecordsToInsert = 1;
      QueryGenerator querygenerator = new QueryGenerator(numberOfRecordsToInsert);

      Statement batch = querygenerator.generateInsertBatch();
      int countOfQueries[] = batch.executeBatch();

      assertEquals("It checks whether the required number of queries are batched", 1, countOfQueries[0]);
  }

    @Test
    public void testGenerateInsertQueryWithoutConstraints(){
        int load = 100;
        QueryGenerator queryGenerator = new QueryGenerator(load);
        ArrayList<Column> columns = new ArrayList<Column>();
        columns.add(new Column("id", "int"));
        columns.add(new Column("email", "string"));

        Schema customerSchema = new Schema("customer", columns);
        ArrayList<String> insertQueriesForCustomer = queryGenerator.generateInsertBatch(customerSchema);

        assertEquals(load, insertQueriesForCustomer.size());
    }

}
