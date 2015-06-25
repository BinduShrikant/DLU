package com.DLU.main;


public class Column {

    private String ColumnName;
    private String DataType;

    Column(String ColumnName, String DataType){

        this.ColumnName = ColumnName;
        this.DataType =DataType;

    }

    public int getValue(){

        if(this.DataType=="int")
            return 999;
        else if(this.DataType=="string");
            return 999;


    }


}
