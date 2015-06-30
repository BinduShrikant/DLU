package com.DLU.main;

import org.junit.Test;
import static org.junit.Assert.*;

public class ColumnTest {

    @Test
    public void testsTheGetValueWithoutTheConstraintReturnsTheAppropriateValueForAnInteger() {

        Column column = new Column("id", "int");

        assertEquals("This test verifies that the value is generated properly when there is no constraint for an integer.", 999, column.getValue());


    }

    @Test
    public void testsTheGetValueWithoutTheConstraintReturnsTheAppropriateValueForAString() {

        Column column=new Column("id","int");
        assertEquals("This test verifies that the value is generated properly when there is no constraint for String.",999,column.getValue());


    }

    @Test
    public void testsTheGetValueWithTheConstraintReturnsTheAppropriateValueForAnInteger() {

        Column column=new Column("id","int");
        int seed=999;
        assertEquals("This test verifies that the value is generated properly when there is no constraint for String.",1000,column.getValue(seed));

    }

    @Test
    public void testsTheGetValueWithTheConstraintReturnsTheAppropriateValueForAString() {

        Column column=new Column("id","int");
        int seed=999;
        assertEquals("This test verifies that the value is generated properly when there is no constraint for String.",1000,column.getValue(seed));


    }
}