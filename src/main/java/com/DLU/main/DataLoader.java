package com.DLU.main;

import java.sql.*;
import java.util.ArrayList;

//Populates the database
public class DataLoader {
    private final Database database;

    public DataLoader(String connectionString, String driver, String username, String password){
        database = Database.getInstance(connectionString, driver, username, password);
    }

    public int populate(int numberOfRecordsToInsert) {

        QueryGenerator queryGenerator = new QueryGenerator(numberOfRecordsToInsert);

        try {

            SchemaDefinition schemaDefinition = generateSchemaDefinitionForCustomer();

            Schema schema = new Schema(schemaDefinition);

            ArrayList<String> insertQueries = queryGenerator.generateInsertQueries(schema);

            //System.out.println(insertQueries);

            database.executeBatchQuery(insertQueries);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return numberOfRecordsToInsert;
    }

    public void cleanDatabase(int numberOfRecordsToInsert) throws SQLException{
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
