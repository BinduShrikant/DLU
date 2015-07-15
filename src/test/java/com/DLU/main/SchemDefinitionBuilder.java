package com.DLU.main;

import java.util.ArrayList;
import java.util.List;

public class SchemDefinitionBuilder {
    private String schemaName;
    private ArrayList<Column> columns = new ArrayList<Column>();
    private ArrayList<Constraint> constraints = new ArrayList<Constraint>();

    public SchemaDefinition Build() {
        return new SchemaDefinition(schemaName, columns, constraints);
    }

    public SchemDefinitionBuilder WithSchemaName(String schemaName) {
        this.schemaName = schemaName;
        return this;
    }

    public SchemDefinitionBuilder WithColumn(String columnName, String columnType) {
        columns.add(new Column(columnName, columnType));
        return this;
    }

    public SchemDefinitionBuilder WithConstraint(Constraints constraint, ArrayList<String> columnsWithConstraint) {
        constraints.add(new Constraint(constraint, getColumns(columnsWithConstraint)));
        return this;
    }

    private ArrayList<Column> getColumns(ArrayList<String> columnsWithConstraintNames) {

        ArrayList<Column> columnsWithConstraint = new ArrayList<Column>();

        for(Column column:columns)
        {
            if(columnsWithConstraintNames.contains(column.getColumnName()) == true){

                columnsWithConstraint.add(column);

            }
        }

        return columnsWithConstraint;
    }

}
