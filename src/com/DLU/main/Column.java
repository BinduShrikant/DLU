package com.DLU.main;

import java.util.List;

public class Column {

    public enum Constraints{
        primarykey,
        uniquekey,
        compositeprimarykey

    }
    public String ColumnName;
    public String Datatype;
    public List<Constraints> constraints;

    public String getValue(){
        return null;
//        return columnValue;
    }

}
