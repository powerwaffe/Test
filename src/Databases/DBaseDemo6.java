package Databases;

import java.sql.*;

/** Created by Sean on 11/19/2015.*/
/*
 * Author: Eric Mailman
 * File Name: DatabaseDemo6.java
 * Purpose: Connect to a MySql database and perform a simple query
 */

public class DBaseDemo6 {

    public static void main(String[] args) throws SQLException {

        try {
            // This needs to be included in the External Libraries:
            // mysql-connector-java-5.1.37-bin.jar
            // for the following statement to work
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");

            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://dtcc150java.tk/db-sean?user=spaoli&password=sp060790");
            System.out.println("Database connection OK");

            // Create a "select" statement
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT `Name` FROM Address; SELECT 'Street' FROM Address");


            // Report results
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            connection.close();
            System.out.println("Program finished without error");
        }
        catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}