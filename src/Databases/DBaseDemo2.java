package Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Sean on 11/12/2015.
 */
public class DBaseDemo2 {

    public static void main(String[] args) throws SQLException {
        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:ucanaccess://C:/Users/Sean/Documents/Database2.accdb");
            System.out.println("Load Students and Courses Tables");

            // Setup an SQL statement
            Statement statement = connection.createStatement();

            // Insert three records into the Students table
            statement.execute("insert into "
                    + "Students (StudentID, StudentName, Major, Department) "
                    + "values (700123456, 'John Jones', 'CT', 'CSC')");
            statement.execute("insert into "
                    + "Students (StudentID, StudentName, Major, Department) "
                    + "values (700123457, 'Jim Jones', 'CT', 'CIS')");
            statement.execute("insert into "
                    + "Students (StudentID, StudentName, Major, Department) "
                    + "values (700123458, 'Jane Jones', 'CT', 'CNE')");

            // Insert three records into the Courses table
            statement.execute("insert into "
                    + "Courses (CRN, CourseName, Major, CourseNumber, Section) "
                    + "values (11594, 'Intro to Programming', 'CIS', 120, '401')");
            statement.execute("insert into "
                    + "Courses (CRN, CourseName, Major, CourseNumber, Section) "
                    + "values (18281, 'Intro to Programming', 'CIS', 120, '4L3')");
            statement.execute("insert into "
                    + "Courses (CRN, CourseName, Major, CourseNumber, Section) "
                    + "values (17451, 'Computer Science 1  ', 'CSC', 114, '401')");

            connection.close();
            System.out.println("Program finished without error");
        }
        catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}