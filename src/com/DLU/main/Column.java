package com.DLU.main;


public class Column {

    private String ColumnName;
    private String DataType;

    Column(String ColumnName, String DataType){

        this.ColumnName = ColumnName;
        this.DataType = DataType;

    }

    public <T> T getValue(){

        if(this.DataType=="int")
            return (T) new Integer(999);
        else if(this.DataType=="string");
            return (T) new String("999");


    }


    public <T> T getValue(int seed) {
        if(this.DataType=="int")
            return (T) new Integer(seed+1);
        else if(this.DataType=="string");
        return (T) new String(String.valueOf(seed+1));
    }

}
