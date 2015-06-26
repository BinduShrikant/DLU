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
        ArrayList<Constraint> listOfConstraints = new ArrayList<Constraint>();

        Database database = Database.getInstance();

        try {

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

            Statement batch = queryGenerator.generateInsertBatch(schema);

            database.executeBatchQuery(batch);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
