package com.DLU.main;

import java.util.ArrayList;

public class SchemaGenerator {

    public ArrayList<Schema> generateTheSchemaOfTheDatabaseTable() {

        ArrayList<Schema> schema =new ArrayList<Schema>();

        Schema currentSchema = new Schema();

        currentSchema.ColumnName = "id";
        currentSchema.Datatype = "int";
        currentSchema.constraints.add(Schema.Constraints.compositeprimarykey);

        schema.add(new Schema("id", "int", new ArrayList<Schema.Constraints>()));

        currentSchema.ColumnName = "sno";
        currentSchema.Datatype = "int";
        currentSchema.constraints.add(Schema.Constraints.compositeprimarykey);

        schema.add(currentSchema);

        currentSchema.ColumnName = "name";
        currentSchema.Datatype = "string";
        currentSchema.constraints.add(Schema.Constraints.uniquekey);

        schema.add(currentSchema);

        currentSchema.ColumnName = "email";
        currentSchema.Datatype = "string";
        currentSchema.constraints.add(Schema.Constraints.uniquekey);

        schema.add(currentSchema);

        currentSchema.ColumnName = "age";
        currentSchema.Datatype = "int";

        schema.add(currentSchema);

        return schema;
    }

}
