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
        listOfConstraints.add(primaryKeyConstraint);

        ArrayList<Column> uniqueKeyColumn= new ArrayList<Column>();
        uniqueKeyColumn.add(nameColumn);
        uniqueKeyColumn.add(emailColumn);
        Constraint uniqueKeyConstraint=new Constraint(Constraints.uniquekey,uniqueKeyColumn);
        listOfConstraints.add(uniqueKeyConstraint);


        schemaDefinition=new SchemaDefinition(name,columns,listOfConstraints);

        String pattern = "insert into .* values(.*,.*)";

        Pattern insertQueryPattern = Pattern.compile(pattern);

        String query = schemaDefinition.getRowToInsert(999);

        Matcher insertQueryMatch = insertQueryPattern.matcher(query);

        assertEquals("This test Checks if the generated Insery Query is in correct format",true,insertQueryMatch.find());

    }
}