package com.DLU.main;

import org.junit.Assert;
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
    public void testThatGetRowsToInsertWhenLoadIsNegative() throws SQLException{


        int load = -21;
        DataLoader dataLoader=new DataLoader();

        SchemaDefinition schemaDefinition = dataLoader.generateSchemaDefinitionForCustomer();

        Schema schema=new Schema(schemaDefinition);

        assertEquals(-1,schema.getRowsToInsert(load));

    }

}