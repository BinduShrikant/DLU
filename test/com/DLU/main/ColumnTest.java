package com.DLU.main;

import org.junit.Test;
import static org.junit.Assert.*;

public class ColumnTest {

    @Test
    public void testsTheGetValueWithoutTheConstraintReturnsTheAppropriateValue() {

        Column column = new Column("id", "int");

        assertEquals("This test verifies that all the values are present.", 999, column.getValue());


    }

    @Test
    public void testsTheGetValueWithTheConstraintReturnsTheAppropriateValue() {


    }
}