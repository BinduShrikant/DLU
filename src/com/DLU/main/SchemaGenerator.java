package com.DLU.main;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SchemaGenerator {

   public Map<String,List<String>> generateTheSchemaOfTheDatabaseTable() {

       Map<String, List<String>> schema = new LinkedHashMap<String, List<String>>();
       List<String> idList = new ArrayList<String>();
       List<String> nameList = new ArrayList<String>();
       List<String> emailList = new ArrayList<String>();

       idList.add("int");
       idList.add("primary key");
       nameList.add("String");
       nameList.add("Null");
       emailList.add("String");
       emailList.add("unique key");

       schema.put("id",idList);
       schema.put("name",nameList);
       schema.put("email",emailList);

       return schema;
   }

}
