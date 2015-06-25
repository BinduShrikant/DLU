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

        String tableName = "customer";
        ArrayList<Column> columnInputs = new ArrayList<Column>();
        Column column = new Column();

        column.ColumnName = "id";
        column.Datatype = "int";
        columnInputs.add(column);
        column.ColumnName = "name";
        column.Datatype = "String";
        columnInputs.add(column);

        Schema schema=new Schema(tableName, columnInputs);

      Statement batch = querygenerator.generateInsertBatch(schema);
      int countOfQueries[] = batch.executeBatch();

      assertEquals("It checks whether the required number of queries are batched", 1, countOfQueries[0]);
  }

}
