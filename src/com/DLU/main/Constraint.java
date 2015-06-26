package com.DLU.main;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Constraint {

    Constraints constraint;
    ArrayList<Column> columnsWithConstraint=new ArrayList<Column>();
    ArrayList<Constraint> listOfConstraints=new ArrayList<Constraint>();


    public Constraint(Constraints constraint,ArrayList<Column> columns) {

        this.constraint = constraint;
        this.columnsWithConstraint=columns;

    }
    public Constraint(ArrayList<Constraint> Constraints) {

        listOfConstraints=Constraints;

    }
}
