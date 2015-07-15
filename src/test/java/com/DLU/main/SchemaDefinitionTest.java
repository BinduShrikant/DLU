package com.DLU.main;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SchemaDefinitionTest{

    @Test
    public void testGetRowsToInsertWhenThereIsEmptySchemaDefinition() {

        SchemaDefinition schemaDefinition=new SchemaDefinition("", new ArrayList<Column>(), new ArrayList<Constraint>());

        String query = schemaDefinition.getRowToInsert(0);

        assertEquals("This test checks if the number of query generated is correct",null,query);

    }


    @Test
    public void testGetRowToInsert() throws SQLException {

        DataLoader dataLoader=new DataLoader("jdbc:h2:mem:cust;MODE=MYSQL", "org.h2.Driver", "root", "");

        SchemaDefinition schemaDefinition = dataLoader.generateSchemaDefinitionForCustomer();
        String query = schemaDefinition.getRowToInsert(999);

        String pattern = "insert into .* values(.*)";
        CustomAsserts.assertQueryPattern(pattern,query);
    }

    @Test
    public void testsForPrimaryKeyConstraint(){

        SchemaDefinition schemaDefinition = generateSchemaDefinitionForCustomer("customer","id","int", Constraints.primarykey);

        String query=schemaDefinition.getRowToInsert(1);

        String pattern = "insert into .* values(.*)";
        CustomAsserts.assertQueryPattern(pattern, query);
    }


    @Test
    public void testsForCompositePrimaryKeyConstraint(){

        SchemaDefinition schemaDefinition = generateSchemaDefinitionForCustomer("customer","id","int",Constraints.compositeprimarykey);

        String query=schemaDefinition.getRowToInsert(1);

        String pattern = "insert into .* values(.*)";
        CustomAsserts.assertQueryPattern(pattern, query);

    }


    @Test
    public void testsForUniqueKeyConstraint(){

        SchemaDefinition schemaDefinition = generateSchemaDefinitionForCustomer("customer","id","int",Constraints.uniquekey);

        String query=schemaDefinition.getRowToInsert(1);

        String pattern = "insert into .* values(.*)";
        CustomAsserts.assertQueryPattern(pattern, query);
    }

    public SchemaDefinition generateSchemaDefinitionForCustomer(String name,String columnName,String columnType,Constraints constraint) {

        ArrayList<String> columnsWithPrimaryKeyConstraint = new ArrayList<String>();
        columnsWithPrimaryKeyConstraint.add("id");

        return new SchemDefinitionBuilder()
                .WithSchemaName("Customer")
                .WithColumn("id", "int")
                .WithColumn("email", "string")
                .WithConstraint(Constraints.primarykey, columnsWithPrimaryKeyConstraint)
                .Build();

    }
}