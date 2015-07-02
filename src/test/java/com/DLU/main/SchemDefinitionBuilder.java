package com.DLU.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bindugo on 02/07/15.
 */
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

    public SchemDefinitionBuilder WithConstraint(Constraints constraint, ArrayList<String> columnWithConstraint) {
        constraints.add(new Constraint(constraint, getColumnsFor(columnWithConstraint)));
        return this;
    }

    private ArrayList<Column> getColumnsFor(ArrayList<String> columnWithConstraint) {
        return null;
    }
}
