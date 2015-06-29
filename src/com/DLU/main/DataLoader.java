package com.DLU.main;

import java.sql.*;
import java.util.ArrayList;

//Populates the database
public class DataLoader {

    public void populate(int numberOfRecordsToInsert) {

        QueryGenerator queryGenerator = new QueryGenerator(numberOfRecordsToInsert);

        String name = "customer";
        SchemaDefinition schemaDefinition;
        ArrayList<Column> columns = new ArrayList<Column>();
        ArrayList<Constraint> constraints = new ArrayList<Constraint>();

        Database database = Database.getInstance();

        try {

            Column idColumn = new Column("id","int");
            columns.add(idColumn);

            Column srColumn = new Column("srno","int");
            columns.add(srColumn);

            Column nameColumn = new Column("name","String");
            columns.add(nameColumn);

            Column emailColumn = new Column("email","String");
            columns.add(emailColumn);

            ArrayList<Column> compositePrimaryKeyColumn= new ArrayList<Column>();
            compositePrimaryKeyColumn.add(idColumn);
            compositePrimaryKeyColumn.add(srColumn);
            Constraint compositePrimaryKeyConstraint=new Constraint(Constraints.compositeprimarykey,compositePrimaryKeyColumn);
            constraints.add(compositePrimaryKeyConstraint);

            ArrayList<Column> uniqueKeyColumn= new ArrayList<Column>();
            uniqueKeyColumn.add(nameColumn);
            uniqueKeyColumn.add(emailColumn);
            Constraint uniqueKeyConstraint=new Constraint(Constraints.uniquekey,uniqueKeyColumn);
            constraints.add(uniqueKeyConstraint);

            schemaDefinition=new SchemaDefinition(name,columns,constraints);

            Schema schema=new Schema(schemaDefinition);

            Statement batch = queryGenerator.generateInsertBatch(schema);

            database.executeBatchQuery(batch);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
