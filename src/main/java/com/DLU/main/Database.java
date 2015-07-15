package com.DLU.main;

import java.sql.*;
import java.util.ArrayList;

//Executed the batch of SQL queries.
public class Database {

    private String connectionString;
    private String driver;
    private String username;
    private String password;
    private static Connection conn = null;

    private Database(String connectionString, String driver, String username, String password) {
        this.connectionString = connectionString;
        this.driver = driver;
        this.username = username;
        this.password = password;
    }


    public static Database getInstance(String connectionString, String driver, String username, String password) {
        return new Database(connectionString, driver, username, password);
    }


    public Connection getConnection() throws SQLException {

        if(conn == null) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(connectionString, username, password);
        }

        return conn;
    }


    public void executeBatchQuery(ArrayList<String> queryList) throws SQLException {

        Connection dbCon = null;

        try {
            dbCon = getConnection();
            dbCon.setAutoCommit(false);
            Statement statement=dbCon.createStatement();

            for(String query:queryList){
                statement.addBatch(query);
            }

            statement.executeBatch();

            dbCon.commit();
            System.out.println("Insertion Committed");

        } catch (SQLException e) {
            if (dbCon != null) {
                dbCon.rollback();

            }
            throw e;

        }
    }




}
