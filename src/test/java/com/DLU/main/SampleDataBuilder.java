package com.DLU.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by saxenas on 03/07/15.
 */
public class SampleDataBuilder {

    public static void createCustomerTable(Database database) throws SQLException {
        Connection connection = null;
        try {
            connection = database.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE customer(id int primary key,srno int,name varchar(255) unique, email varchar(255) unique, createdDate date)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.commit();
        }
    }


    public static void createCustomerTable() throws SQLException {
        createCustomerTable(getDatabase());
    }

    private static Database getDatabase() {
        return Database.getInstance("jdbc:h2:mem:cust;MODE=MYSQL", "org.h2.Driver", "root", "");
    }

    public static void cleanup(Database database) throws SQLException {
        Connection connection = null;
        try {
            connection = database.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE customer");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.commit();
        }
    }

    public static void cleanup() throws SQLException {
        cleanup(getDatabase());
    }
}
