package com.DLU.main;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SchemaTest{

    @Test
    public void testGetRowsToInsert() {

        String tableName = "customer";
        ArrayList<Column> columnInputs = new ArrayList<Column>();
        Column column = new Column();

        column.ColumnName = "id";
        column.Datatype = "int";
        columnInputs.add(column);
        column.ColumnName = "name";
        column.Datatype = "String";
        columnInputs.add(column);

        Schema schema = new Schema(tableName, columnInputs);

        ArrayList<String> queryList = schema.getRowsToInsert(5);

        assertEquals("This test checks if the number of query generated is correct",5,queryList.size());

    }
}