package com.DLU.main;

import org.apache.commons.lang3.StringUtils;
//import com.DLU.main.SchemaGenerator;
import com.DLU.main.Database;
import java.sql.*;
import java.util.*;

//Generates the query based on the request
public class QueryGenerator {

    private Random random;

    QueryGenerator(int numberOfRecordsToInsert){

        random = new Random(numberOfRecordsToInsert);

    }

    public Statement generateInsertBatch(int numberOfRecordsToInsert) throws SQLException{

        Database database=new Database();
        String tablename="customer";

        Connection dbCon = null;
        dbCon=database.getConnection();
        Statement stmt=dbCon.createStatement();

        while(numberOfRecordsToInsert>0) {

            String query = generateInsertQuery(tablename);
            stmt.addBatch(query);

            numberOfRecordsToInsert = numberOfRecordsToInsert - 1;
        }

        return stmt;
    }


    private String generateInsertQuery(String tablename) throws SQLException{

        ArrayList<String> columns = generateInsertQueryValues();

        String columnNamesString = StringUtils.join(columns, ',');

        return String.format("insert into %s values(%s)", tablename, columnNamesString);


    }

    private ArrayList<String> generateInsertQueryValues() {

        SchemaGenerator schemagenerator =new SchemaGenerator();
        Map<String, List<String>> schema;
        schema = schemagenerator.generateTheSchemaOfTheDatabaseTable();

        ArrayList<String> columns = new ArrayList<String>();

        String randomValue = String.valueOf(random.nextInt());


        for(Map.Entry<String,List<String>> entry : schema.entrySet()){

            List<String> valueList = entry.getValue();

            if((valueList.get(0).compareTo("int"))==0 && valueList.get(1).compareTo("primary key")==0){
                columns.add(randomValue);
            }
            else if((valueList.get(0).compareTo("String"))==0 && valueList.get(1).compareTo("unique key")==0){
                columns.add("\"" + randomValue + "@gmail.com\"");
            }
            else if((valueList.get(0).compareTo("String"))==0 ){
                columns.add("\"xyz\"");
            }


        }
        return columns;


    }


}
