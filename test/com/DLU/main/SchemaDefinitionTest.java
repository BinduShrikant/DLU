package com.DLU.main;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static com.DLU.main.CustomAsserts.*;

import org.junit.Test;

public class SchemaDefinitionTest{


    @Test
    public void testGetRowToInsert(){


        DataLoader dataLoader=new DataLoader();

        SchemaDefinition schemaDefinition = dataLoader.generateSchemaDefinitionForCustomer();
        String query = schemaDefinition.getRowToInsert(999);

        assertInsertQueryPattern(query);
    }

    @Test
    public void testsForPrimaryKeyConstraint(){

        SchemaDefinition schemaDefinition = generateSchemaDefinitionForCustomer("customer","id","int",Constraints.primarykey);

        String query=schemaDefinition.getRowToInsert(1);

        assertInsertQueryPattern(query);
    }


    @Test
    public void testsForCompositePrimaryKeyConstraint(){

        SchemaDefinition schemaDefinition = generateSchemaDefinitionForCustomer("customer","id","int",Constraints.compositeprimarykey);

        String query=schemaDefinition.getRowToInsert(1);

        assertInsertQueryPattern(query);


    }


    @Test
    public void testsForUniqueKeyConstraint(){

        SchemaDefinition schemaDefinition = generateSchemaDefinitionForCustomer("customer","id","int",Constraints.uniquekey);

        String query=schemaDefinition.getRowToInsert(1);

        assertInsertQueryPattern(query);

    }

    public SchemaDefinition generateSchemaDefinitionForCustomer(String name,String columnName,String columnType,Constraints constraint) {

        ArrayList<Column> columns = new ArrayList<Column>();
        ArrayList<Constraint> constraints = new ArrayList<Constraint>();

        Column column = new Column(columnName,columnType);
        columns.add(column);


        ArrayList<Column> constraintColumn= new ArrayList<Column>();
        constraintColumn.add(column);
        Constraint newConstraint=new Constraint(constraint,constraintColumn);
        constraints.add(newConstraint);

        return new SchemaDefinition(name,columns,constraints);

    }
}