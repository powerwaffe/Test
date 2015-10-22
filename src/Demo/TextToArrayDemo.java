package Demo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class TextToArrayDemo {
    private double average;
    private double total;
    static int lineCount;
    static int testCount;

    public static void main(String[] bucket) {
        returnTextFile();
        writeTextFile();
    }

    /**Create new text file*/
    public static void writeTextFile() {
        try {
            File myFile = new File("finalGrade.txt");
            PrintWriter output = new PrintWriter(myFile);

            output.println("Your grades are: ");
            for (int i =1 ; i<=10; i++)
                output.print(i + " ");

            System.out.println("\n");

            output.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**Method for reading*/
    public static void returnTextFile() {
         ArrayList<Integer> arrList = new ArrayList<Integer>();

        try {
            // File myFile = new File("data_txt");
            Scanner bob = new Scanner(new File("gradeBook.txt"));

            while (bob.hasNext()) {

                try {
                    String mine = bob.nextLine();
                    String[] tokens = mine.split(" ");
                    double grabber = bob.nextInt();

                    int[][] arr = new int[tokens.length][tokens.length];
                    for (int i=0; i< tokens.length; i++)
                        for (int j=0; j< tokens.length; j++)
                            arr[i][j] = i+j;
                    System.out.println(arr[0][0]);


                    lineCount++;

                } catch (InputMismatchException e) {
                    //System.out.println("Non-integer data was read");
                    bob.next();
                }
            }
           // System.out.println(lineCount);
            bob.close();

        } catch (FileNotFoundException e) {
            System.out.println("Failed to open file " + e.getMessage());
        }
    }

    /**Method for getting average of test*/
    public void testAverage() {

    }

    /**Method for getting student average*/
    public void studendAverage() {

    }
}
/**TRY THIS!
 * String line = "John Smith  92  80  86  76  95";
 String[] tokens = line.split("\\s+");

 SPLIT RETURNS :
 tokens = { "John", "Smith", "92", "80", "76", "95" };

 USE THE INDICES [0][1] ARE STRING AND PARSE [2][3][4]..
 String firstName = tokens[0];
 String lastName = tokens[1];
 int hw = Integer.parseInt(tokens[2]);
 */









