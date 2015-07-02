package com.DLU.main;

import java.sql.*;
import java.util.ArrayList;

//Populates the database
public class DataLoader {

    public int populate(int numberOfRecordsToInsert) {

        QueryGenerator queryGenerator = new QueryGenerator(numberOfRecordsToInsert);
        Database database = Database.getInstance();

        try {

            if(numberOfRecordsToInsert<50001 && numberOfRecordsToInsert>0) {

                SchemaDefinition schemaDefinition = generateSchemaDefinitionForCustomer();

                Schema schema = new Schema(schemaDefinition);

                ArrayList<String> insertQueries = queryGenerator.generateInsertQueries(schema);

                database.executeBatchQuery(insertQueries);

                return 0;
            }
            else {

                System.out.println("Limit [0-50000]");

                return -1;

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return numberOfRecordsToInsert;
    }

    public void cleanDatabase(int numberOfRecordsToInsert) throws SQLException{

        Database database = Database.getInstance();
        Connection dbCon=database.getConnection();
        Statement stmt=dbCon.createStatement();
        String query=String.format("delete from %s where 0<id<%s;","customer",numberOfRecordsToInsert);

        stmt.executeUpdate(query);
        dbCon.commit();
        System.out.println("Database cleaned");
    }

    public SchemaDefinition generateSchemaDefinitionForCustomer() throws SQLException {
        ArrayList<Column> columns = new ArrayList<Column>();
        ArrayList<Constraint> constraints = new ArrayList<Constraint>();


        String name = "customer";

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

        return new SchemaDefinition(name,columns,constraints);

    }

}