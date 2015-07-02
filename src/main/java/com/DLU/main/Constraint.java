package com.DLU.main;

import java.util.ArrayList;


public class Constraint {

    Constraints constraint;
    ArrayList<Column> columnsWithConstraint=new ArrayList<Column>();


    public Constraint(Constraints constraint,ArrayList<Column> columns) {

        this.constraint = constraint;
        this.columnsWithConstraint=columns;

    }
}
