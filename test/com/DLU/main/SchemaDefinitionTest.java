package com.DLU.main;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

import org.junit.Test;

public class SchemaDefinitionTest{

    @Test
    public void testGetRowToInsert(){

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

        String pattern = "insert into .* values(.*,.*)";

        Pattern insertQueryPattern = Pattern.compile(pattern);

        String query = schemaDefinition.getRowToInsert();

        Matcher insertQueryMatch = insertQueryPattern.matcher(query);

        assertEquals("This test Checks if the generated Insery Query is in correct format",true,insertQueryMatch.find());

    }
}