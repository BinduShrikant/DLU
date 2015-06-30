package com.DLU.main;


import java.text.*;
import java.util.Date;

public class Column {

    private String ColumnName;
    private String DataType;

    Column(String ColumnName, String DataType){

        this.ColumnName = ColumnName;
        this.DataType = DataType;

    }

    public <T> T getValue(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();

        if(this.DataType=="int")
            return (T) new Integer(999);
        else if(this.DataType=="string")
            return (T) new String("999");
        else if(this.DataType=="date")
            return (T) new String("\""+dateFormat.format(date)+"\"");


        return null;

    }


    public <T> T getValue(int seed) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();

        if(this.DataType=="int")
            return (T) new Integer(seed+1);
        else if(this.DataType=="string")
            return (T) new String(String.valueOf(seed+1));
        else if(this.DataType=="date")
            return (T) new String("\""+dateFormat.format(date)+"\"");

        return null;
    }

}
