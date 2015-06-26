package com.DLU.main;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SchemaTest{

    @Test
    public void testGetRowsToInsert() {

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

        ArrayList<String> queryList = schema.getRowsToInsert(5);

        assertEquals("This test checks if the number of query generated is correct",5,queryList.size());

    }
}