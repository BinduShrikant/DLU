package com.DLU.main;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SchemaGenerator {

   public Map<String,List<String>> generateTheSchemaOfTheDatabaseTable() {

       Map<String, List<String>> schema = new LinkedHashMap<String, List<String>>();
       List<String> idList = new ArrayList<String>();
       List<String> snoList = new ArrayList<String>();
       List<String> nameList = new ArrayList<String>();
       List<String> emailList = new ArrayList<String>();

       idList.add("int");
       idList.add("composite primary key");
       snoList.add("int");
       snoList.add("composite primary key");
       nameList.add("String");
       nameList.add("unique key");
       emailList.add("String");
       emailList.add("unique key");

       schema.put("id",idList);
       schema.put("sno",snoList);
       schema.put("name",nameList);
       schema.put("email",emailList);

       return schema;
   }

}
