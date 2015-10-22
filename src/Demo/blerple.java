package Demo;
import java.io.*;
import java.util.*;

/**
 * Created by Sean on 10/13/2015.
 */
public class blerple {
    private static int countRows;
    private static int countColumns;

    public static void main(String[] ducks) throws IOException {
        /**Write a program that reads the text file and writes a grade summary
         * report to a text file with the average score on each test and the average grade of each student.
         *
         * Open file a second time to grab variable for .length witch is number of columns
         * Columns-1 = TESTS1-4
         * Rows-1 = 23 34 54
         * */
        Scanner input = new Scanner(new File("gradeBook.txt")); //open scanner
        double grade = 0;
        String separator = " ";
        String[] StrArray;

        try {

            File fileOut = new File("gradeBookOut.txt"); //create file object
            PrintWriter output = new PrintWriter(fileOut); //object for printing to file

            while (input.hasNext()) {

                try {
                    String next = input.nextLine(); //scan per line
                    String[] tokens = next.split(separator); //tokens with separator


                 
                    

                  //  grade+=Double.parseDouble(tokens[1]);
                    // System.out.println(tokens[1]);
                    /**Tokens [1]-[3] are the columns for the tests*/
                    output.println(tokens[0] + " " + tokens[1] + " " + tokens[2] +
                            " " + tokens[3]); //prints out tokens at index [1]

                    countRows++; //count number of rows


                } catch (InputMismatchException e) {
                    input.next();
                }
            }
            countRows-=1;
            System.out.println("\nLine Count is " + countRows); //count number of students
            System.out.print(grade);
            input.close();
            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("Failed to open file " + e.getMessage());
        }
        /**TRY TO OPEN TO COUNT LENGTH OR COLUMNS*/

        try {
            Scanner bob2 = new Scanner(new File("gradeBook.txt"));

            while (bob2.hasNext()) {

                try {
                    String mine = bob2.nextLine(); //scan per line

                    //String[] tokens = mine.split("Test1|Test2|Test3|Test4|Name|Larry|Jojo|Farv"); //split into tokens
                    String[] tokens = mine.split(" ");
                    countColumns = tokens.length;

                } catch (InputMismatchException e) {
                    bob2.next();
                }
            }
            countColumns-=1; //Number of columns
            //System.out.println("Number of columns are " + countColumns);
            bob2.close();

        } catch (FileNotFoundException e) {
            System.out.println("Failed to open file " + e.getMessage());
        }
        /**Sum all values by column to find average per test*/

        try {
            Scanner inputArray = new Scanner(new File("gradeBook.txt"));

            //int[][] matrix = new int[countRows][countColumns]; //New 2D array to store gradebook.txt int values in
            //System.out.println("Matrix length is " + matrix.length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
