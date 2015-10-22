package Demo;
import java.io.*;
import java.util.*;
/**
 * Created by Sean on 10/14/2015.
 */

public class TesterGrade {
    private static int countRows;
    private static int countColumns;
    private static int[] demoArr;

    public static void main(String[] ducks) {
        /**Write a program that reads the text file and writes a grade summary
         * report to a text file with the average score on each test and the average grade of each student.
         *
         * Open file a second time to grab variable for .length witch is number of columns
         * Columns-1 = TESTS1-4
         * Rows-1 = 23 34 54
         * */
        ArrayList<String> loadLines = new ArrayList<>();
        double grade = 0;
        try {
            Scanner bob = new Scanner(new File("gradeBook.txt"));

            while (bob.hasNext()) {

                try {
                   // String mine = bob.nextLine(); //scan per line
                    loadLines.add(bob.nextLine());

                    //String[] tokens = mine.split("|Test1|Test2|Test3|Test4|Name|Larry|Jojo|Darwin"); //split into tokens
                  //  String[] tokens = mine.split(" ");

                    // String[] numberStrs = mine.split(" |Test1|Test2|Test3|Name|Larry|Jojo|Darwin");
                    /**for (int i = 0; i < tokens.length; i++)
                     System.out.print(tokens[i]);
                     int[] numbers = new int[tokens.length];
                     for(int i = 0;i < tokens.length;i++) {
                     // Note that this is assuming valid input
                     // If you want to check then add a try/catch
                     // and another index for the numbers if to continue adding the others
                     numbers[i] = Integer.parseInt(tokens[i]);
                     }
                     // for (int i = 0; i < numbers.length; i++)*/
                    //    System.out.println(numbers[i]);


                    /**Tokens [1]-[3] are the columns for the tests*/
                  //  System.out.println(tokens[1]); //prints out tokens at index [1]

                    countRows++; //count number of rows


                } catch (InputMismatchException e) {
                    bob.next();
                }
            }
            countRows-=1;
            System.out.println("\nLine Count is " + countRows); //count number of students
            System.out.println(loadLines);
            bob.close();

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
            System.out.println("Number of columns are " + countColumns);
            bob2.close();

        } catch (FileNotFoundException e) {
            System.out.println("Failed to open file " + e.getMessage());
        }
        /**Sum all values by column to find average per test*/

   //     System.out.println("Hi! I'm at line 75!");
     //   System.out.println("\nAverage score per test....");

        try {
            Scanner inputArray = new Scanner(new File("gradeBook.txt"));

            double[][] matrix = new double[countRows][countColumns]; //New 2D array to store gradebook.txt int values in
           // System.out.println("Matrix length is " + matrix.length);




            /**  for (int row = 0; row < matrix.length; row++) {
                  for (int column = 0; column < matrix[row].length; column++) {
                      System.out.print(matrix[row][column] + " ");
                  }
              }
          */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

