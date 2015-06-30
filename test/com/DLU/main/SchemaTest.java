package com.DLU.main;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class SchemaTest{

    @Test
    public void testGetRowsToInsert() {

        String name = "customer";
        SchemaDefinition schemaDefinition;
        ArrayList<Column> columns = new ArrayList<Column>();
        ArrayList<Constraint> listOfConstraints = new ArrayList<Constraint>();

        Column idColumn = new Column("id","int");
        columns.add(idColumn);

        Column srColumn = new Column("srno","int");
        columns.add(srColumn);

        Column nameColumn = new Column("name","String");
        columns.add(nameColumn);

        Column emailColumn = new Column("email","String");
        columns.add(emailColumn);

        Column dateColumn = new Column("createdDate","date");
        columns.add(dateColumn);

        ArrayList<Column> primaryKeyColumn= new ArrayList<Column>();
        primaryKeyColumn.add(idColumn);
        Constraint primaryKeyConstraint=new Constraint(Constraints.primarykey,primaryKeyColumn);
        listOfConstraints.add(primaryKeyConstraint);

        ArrayList<Column> uniqueKeyColumn= new ArrayList<Column>();
        uniqueKeyColumn.add(nameColumn);
        uniqueKeyColumn.add(emailColumn);
        Constraint uniqueKeyConstraint=new Constraint(Constraints.uniquekey,uniqueKeyColumn);
        listOfConstraints.add(uniqueKeyConstraint);


        schemaDefinition=new SchemaDefinition(name,columns,listOfConstraints);

        Schema schema=new Schema(schemaDefinition);

        ArrayList<String> queryList = schema.getRowsToInsert(5);

        assertEquals("This test checks if the number of query generated is correct",5,queryList.size());

    }
}