package com.DLU.main;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

import org.junit.Test;

public class SchemaDefinitionTest{

    @Test
    public void testGetRowToInsert(){

        String tableName = "customer";
        ArrayList<Column> columnInputs = new ArrayList<Column>();
        Column column = new Column();

        column.ColumnName = "id";
        column.Datatype = "int";
        columnInputs.add(column);
        column.ColumnName = "name";
        column.Datatype = "String";
        columnInputs.add(column);

        String pattern = "insert into .* values(.*,.*)";

        Pattern insertQueryPattern = Pattern.compile(pattern);

        SchemaDefinition schemaDefinition = new SchemaDefinition(tableName, columnInputs);

        String query = schemaDefinition.getRowToInsert();

        Matcher insertQueryMatch = insertQueryPattern.matcher(query);

        assertEquals("This test Checks if the generated Insery Query is in correct format",true,insertQueryMatch.find());

    }
}