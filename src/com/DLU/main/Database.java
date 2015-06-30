package com.DLU.main;

import java.sql.*;
import java.util.ArrayList;

//Executed the batch of SQL queries.
public class Database {

    private String connectionString;
    private String username;
    private String password;
    private static Connection conn = null;
    private static Database database = new Database();

    private Database() {
        connectionString = "jdbc:mysql://localhost:3306/cust?" + "&rewriteBatchedStatements=true";
        username = "root";
        password = "";
    }


    public static Database getInstance() {
        return database;
    }


    public Connection getConnection() throws SQLException {

        if(conn == null) {
            conn = DriverManager.getConnection(connectionString, username, password);
        }

        return conn;
    }


    public void executeBatchQuery(ArrayList<String> queryList) throws SQLException {

        Connection dbCon = null;

        try {
            dbCon = getConnection();
            dbCon.setAutoCommit(false);
            Statement batch=dbCon.createStatement();
            for(String query:queryList){
                batch.addBatch(query);
            }

            batch.executeBatch();

            dbCon.commit();
            System.out.println("Insertion Committed");

        } catch (SQLException e) {

            e.printStackTrace();
            if (dbCon != null) {
                dbCon.rollback();

            }

        }
    }

    public void cleanDatabase(int numberOfRecordsToInsert) throws SQLException{

        Connection dbCon=getConnection();
        Statement stmt=dbCon.createStatement();
        String query=String.format("delete from %s where 0<id<%s;","customer",numberOfRecordsToInsert);

        stmt.executeUpdate(query);
        dbCon.commit();
        System.out.println("Database cleaned");
    }


}
