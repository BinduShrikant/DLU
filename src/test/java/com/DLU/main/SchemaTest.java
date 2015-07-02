package com.DLU.main;

import com.DLU.main.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class SchemaTest{

    @Test
    public void testGetRowsToInsert() throws SQLException {


        DataLoader dataLoader=new DataLoader();

        SchemaDefinition schemaDefinition = dataLoader.generateSchemaDefinitionForCustomer();

        Schema schema=new Schema(schemaDefinition);

        ArrayList<String> queryList = schema.getRowsToInsert(5);

        assertEquals("This test checks if the number of query generated is correct",5,queryList.size());

    }
    @Test
    public void testGetRowsToInsert1() {


        DataLoader dataLoader=new DataLoader();

        Schema schema=new Schema(new SchemaDefinition("", new ArrayList<Column>(), new ArrayList<Constraint>()));

        ArrayList<String> queryList = schema.getRowsToInsert(5);

        assertEquals("This test checks if the number of query generated is correct",5,queryList.size());

    }
}