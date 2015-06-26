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

        String name = "customer";
      SchemaDefinition schemaDefinition;
        ArrayList<Column> columns = new ArrayList<Column>();
      ArrayList<Constraint> listOfConstraints = new ArrayList<Constraint>();


      Column idColumn = new Column("id","int");
      columns.add(idColumn);

      Column nameColumn = new Column("name","String");
      columns.add(nameColumn);

      ArrayList<Column> primarykeycolumn= new ArrayList<Column>();
      primarykeycolumn.add(idColumn);
      Constraint primarykeyconstraint=new Constraint(Constraints.primarykey,primarykeycolumn);
      listOfConstraints.add(primarykeyconstraint);

      ArrayList<Column> uniquekeycolumn= new ArrayList<Column>();
      uniquekeycolumn.add(nameColumn);
      Constraint uniquekeyconstraint=new Constraint(Constraints.uniquekey,uniquekeycolumn);
      listOfConstraints.add(uniquekeyconstraint);

      schemaDefinition=new SchemaDefinition(name,columns,listOfConstraints);

      Schema schema=new Schema(schemaDefinition);


      Statement batch = querygenerator.generateInsertBatch(schema);
      int countOfQueries[] = batch.executeBatch();

      assertEquals("It checks whether the required number of queries are batched", 1, countOfQueries[0]);
  }

}
