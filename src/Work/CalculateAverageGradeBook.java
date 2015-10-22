package Work;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Created by Sean on 10/11/2015.
 */
public class CalculateAverageGradeBook {
    public static void main(String[] duck) throws IOException {
        java.io.File file = new java.io.File("gradeBook.txt");
        Scanner input = new Scanner(file);

        int[] array;
        while (input.hasNext()) {

            String firstName = input.next(); //row
            String test1 = input.nextLine(); //column
            String[] tokens = test1.split("Test");

           // System.out.println(firstName + " " + test1 + " ");
           // System.out.println(test1.split("Larry"));
            for (int i =0; i<tokens.length;i++)
            System.out.print(tokens[i / tokens.length]);

            System.out.println();
        }
            input.close();
        }
    }

