package com.DLU.main;



//tests the QueryGenerator class
import org.junit.Test;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryGeneratorTest {

    @Test
    public void testGenerateInsertQueries() throws SQLException {

      int numberOfRecordsToInsert = 1;
      QueryGenerator querygenerator = new QueryGenerator(numberOfRecordsToInsert);

      DataLoader dataLoader=new DataLoader();

      SchemaDefinition schemaDefinition = dataLoader.generateSchemaDefinitionForCustomer();

      Schema schema=new Schema(schemaDefinition);

      ArrayList<String> batch = querygenerator.generateInsertQueries(schema);

      assertEquals("It checks whether the required number of queries are generated", 1, batch.size());
  }

}
