package Demo;

/**
 * Created by Sean on 10/13/2015.
 */
import java.util.*;
import java.io.*;
import java.text.*;
public class tester {
    public static void main(String[]args) throws IOException {


        File inputFile = new File("scores.txt");
        Scanner data = new Scanner(inputFile);
        DecimalFormat averages = new DecimalFormat("#.#");
        int students = data.nextInt();
        int assignments = data.nextInt();
        double gradebook[][] = new double [students + 1][assignments + 1];

        //putting the scores into the array
        for (int i=0; i<students; i++) { //rows
            for (int j=0; j<assignments; j++) { //coloums
                gradebook[i][j] = data.nextDouble();
            }
        }

        //calculating the average assignment score for each student (coloums)
        for (int i=0; i<students; i++) {
            double studentTotal = 0;
            for (int j=0; j<assignments; j++) {
                studentTotal = studentTotal + gradebook[i][j];
            }
            gradebook[i][assignments] = studentTotal/assignments;
        }

        //calculating the average score of each assigment for all students (rows)
        for (int j=0; j<assignments; j++) {
            double assignmentTotal = 0;
            for (int i=0; i<students; i++) {
                assignmentTotal = assignmentTotal + gradebook[i][j];
            }
            gradebook[students][j] = assignmentTotal/students;
        }


        //printing the gradebook
        System.out.print("\t\t\t\tAssignment #:\n\t\t");
        for (int j=0; j<assignments; j++) {
            System.out.print((j+1) + "\t");
        }

        System.out.println("Avg");
        for (int i=0; i<students; i++) {
            System.out.print("Student #" + (i+1) + ":\t");
            for (int j=0; j<assignments; j++) {
                System.out.print(gradebook[i][j] + "\t");
            }
            System.out.println(averages.format(gradebook[i][assignments]));
        }
        System.out.print("Average\t\t");
        for (int j=0; j<assignments; j++) {
            System.out.print(averages.format(gradebook[students][j]) + "\t");
        }
        System.out.println();

        double overallAvg = 0;
        for (int i=0; i<students; i++) {
            overallAvg = overallAvg + gradebook[i][assignments];
        }

        System.out.println("\nOverall Average: " + averages.format(overallAvg/students));
    }
}