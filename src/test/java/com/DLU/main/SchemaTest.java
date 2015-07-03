package com.DLU.main;

import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class SchemaTest{
    private static Schema schema;

    @BeforeClass
    public static void setup() throws SQLException {
        //schemadefinitionbuilder : todo
        DataLoader dataLoader = new DataLoader("jdbc:h2:mem:cust;MODE=MYSQL", "org.h2.Driver", "root", "");
        SchemaDefinition schemaDefinition = dataLoader.generateSchemaDefinitionForCustomer();
        schema = new Schema(schemaDefinition);
    }

    @Test
    public void testGetRowsToInsert() throws SQLException {

        ArrayList<String> queryList = schema.getRowsToInsert(5);

        assertEquals("This test checks if the number of query generated is correct",5,queryList.size());

    }


    @Test
    public void testThatGetRowsToInsertWhenLoadIsNegative() throws SQLException{

        int load = -21;

        assertEquals("This test checks that DLU.populate fails when passed a negative value",-1,schema.getRowsToInsert(load));

    }

}