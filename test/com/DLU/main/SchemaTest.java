package com.DLU.main;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SchemaTest{

    @Test
    public void testGetRowsToInsert() {

        Schema schema = new Schema();

        ArrayList<String> queryList = schema.getRowsToInsert(5);

        assertEquals("This test checks if the number of query generated is correct",5,queryList.size());

    }
}