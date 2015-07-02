package com.DLU.main;

import com.DLU.main.Column;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ColumnTest {

    @Test
    public void testsTheGetValueWithoutTheConstraintReturnsTheAppropriateValueForAnInteger() {

        Column column = new Column("id", "int");

        Assert.assertEquals("This test verifies that the value is generated properly when there is no constraint for an integer.", 999, column.getValue());


    }

    @Test
    public void testsTheGetValueWithoutTheConstraintReturnsTheAppropriateValueForAString() {

        Column column=new Column("name","string");
        Assert.assertEquals("This test verifies that the value is generated properly when there is no constraint for String.", "999", column.getValue());

    }


    @Test
    public void testsTheGetValueWithoutTheConstraintReturnsTheAppropriateValueForADate() {

        Column column=new Column("create","date");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();

        Assert.assertEquals("This test verifies that the value is generated properly when there is no constraint for Date.", "\"" + dateFormat.format(date) + "\""
                , column.getValue());

    }

    @Test
    public void testsTheGetValueWithTheConstraintReturnsTheAppropriateValueForAnInteger() {

        Column column=new Column("id","int");
        int seed=999;
        Assert.assertEquals("This test verifies that the value is generated properly when there is no constraint for integer.", 1000, column.getValue(seed));

    }

    @Test
    public void testsTheGetValueWithTheConstraintReturnsTheAppropriateValueForAString() {

        Column column=new Column("name","string");
        int seed=999;
        Assert.assertEquals("This test verifies that the value is generated properly when there is no constraint for String.", "1000", column.getValue(seed));


    }

    @Test
    public void testsTheGetValueWithTheConstraintReturnsTheAppropriateValueForADate() {

        Column column=new Column("create","date");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        int seed = 999;

        Assert.assertEquals("This test verifies that the value is generated properly when there is no constraint for Date.", "\"" + dateFormat.format(date) + "\"", column.getValue(seed));

    }
}