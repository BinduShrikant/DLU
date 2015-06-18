package com.DLU.main;

import java.sql.*;

//Executed the batch of SQL queries.
public class Database {

    private String connectionString;
    private String username;
    private String password;
    private static Database database = new Database( );

    private Database() {
        connectionString = "jdbc:mysql://localhost:3306/cust?"+"&rewriteBatchedStatements=true";
        username = "root";
        password = "";
    }


    public static Database getInstance( ) {
        return database;
    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString, username, password);
    }


    public void executeBatchQuery(Statement batch) throws SQLException{

        Connection dbCon = null;

        try {
              dbCon = getConnection();
              dbCon.setAutoCommit(false);

              batch.executeBatch();

              dbCon.commit();
              System.out.println("Insertion Committed");

        }
        catch (SQLException e) {

            e.printStackTrace();
                if (dbCon != null) {
                    dbCon.rollback();

                }

        }
    }


}
