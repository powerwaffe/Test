package Databases;

/**
 * Created by Sean on 11/12/2015.
 */
import java.sql.*;

/*
 * Author: Eric Mailman
 * File Name: DatabaseDemo1.java
 * Purpose: Connect to a database and perform a simple query
 */

public class DBaseDemo1 {

    public static void main(String[] args) throws SQLException {

        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:ucanaccess://C:/Users/Sean/Documents/Database1.accdb");

            // Create a "select" statement
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT [Last Name], [First Name] FROM [Students]");

            // Report results
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

            connection.close();
            System.out.println("Program finished without error");
        }
        catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}