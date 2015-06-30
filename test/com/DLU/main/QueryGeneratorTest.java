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
      ArrayList<Constraint> constraints = new ArrayList<Constraint>();


      Column idColumn = new Column("id","int");
      columns.add(idColumn);

      Column srColumn = new Column("srno","int");
      columns.add(srColumn);

      Column nameColumn = new Column("name","string");
      columns.add(nameColumn);

      Column emailColumn = new Column("email","string");
      columns.add(emailColumn);

      Column dateColumn = new Column("createdDate","date");
      columns.add(dateColumn);

      ArrayList<Column> primaryKeyColumn= new ArrayList<Column>();
      primaryKeyColumn.add(idColumn);
      Constraint primaryKeyConstraint=new Constraint(Constraints.primarykey,primaryKeyColumn);
      constraints.add(primaryKeyConstraint);

      ArrayList<Column> uniqueKeyColumn= new ArrayList<Column>();
      uniqueKeyColumn.add(nameColumn);
      uniqueKeyColumn.add(emailColumn);
      Constraint uniqueKeyConstraint=new Constraint(Constraints.uniquekey,uniqueKeyColumn);
      constraints.add(uniqueKeyConstraint);


      schemaDefinition=new SchemaDefinition(name,columns,constraints);

      Schema schema=new Schema(schemaDefinition);


      ArrayList<String> batch = querygenerator.generateInsertQueries(schema);

      assertEquals("It checks whether the required number of queries are batched", 1, batch.size());
  }

}
