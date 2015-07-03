package com.DLU.main;



//tests the QueryGenerator class
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryGeneratorTest {

  @AfterClass
  public static void tearDown() throws SQLException {
    SampleDataBuilder.cleanup();
  }

  @Test
    public void testGenerateInsertQueries() throws SQLException {

      int numberOfRecordsToInsert = 1;
      QueryGenerator querygenerator = new QueryGenerator(numberOfRecordsToInsert);

      DataLoader dataLoader=new DataLoader("jdbc:h2:mem:cust;MODE=MYSQL", "org.h2.Driver", "root", "");
      SampleDataBuilder.createCustomerTable();

      SchemaDefinition schemaDefinition = dataLoader.generateSchemaDefinitionForCustomer();

      Schema schema=new Schema(schemaDefinition);

      ArrayList<String> batch = querygenerator.generateInsertQueries(schema);

      assertEquals("It checks whether the required number of queries are generated", 1, batch.size());
  }

}
