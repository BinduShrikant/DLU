package com.DLU.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

import org.junit.Test;

public class SchemaDefinitionTest{

    @Test
    public void testGetRowToInsert(){

        Schema schema = new Schema();

        String pattern = "insert into .* values(.*,.*)";

        Pattern insertQueryPattern = Pattern.compile(pattern);

        String query = schema.getRowToInsert();

        Matcher insertQueryMatch = insertQueryPattern.matcher(query);

        assertEquals("This test Checks if the generated Insery Query is in correct format",true,insertQueryMatch.find());

    }
}