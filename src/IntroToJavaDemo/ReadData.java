package IntroToJavaDemo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Sean on 10/11/2015.
 */
public class ReadData {
    public static void main(String[] duck) throws Exception {
        /**Create a file instance*/
        java.io.File file = new java.io.File("scores.txt");

        /**Create a scanner for the file*/
        Scanner input = new Scanner(file);

        /**Read data from a file*/
        while (input.hasNext()) {
            String firstName = input.next();
            String mi = input.next();
            String lastName = input.next();
            int score = input.nextInt();
            System.out.println(firstName + " " +  mi + " " + lastName + " " + score);
        }

        /**Close the file*/
        input.close();
    }
}
