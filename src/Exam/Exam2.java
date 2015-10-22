package Exam;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Sean Paoli
 * CIS 150-401
 * This program will take an input file and will modify it as well as print the
 * modified file to an output file.
 *
 * Tried and failed:
 * -Could not find a feasible way to print output correctly.
 * -Could not figure out the elements that were incorrect while modifying output
 * to only show the correct elements.
 */
public class Exam2 {
    private static int wordCount;

    public static void main(String[] ducks) throws IOException {
        File file = new File("file_in.txt"); //create file object
        File fileOut = new File("file_out.txt"); //create output file object
        PrintWriter output = new PrintWriter(fileOut); //create printWriter object
        ArrayList<String> address = new ArrayList<>(); //create arrayList

        try {
            Scanner input = new Scanner(file);

            while (input.hasNext()) { //loop read through input file

                String line = input.nextLine(); //create string to read line
                String[] tokens = line.split(";"); //split line into tokens with delimiter

                for (int i=0; i < tokens.length;i++) //load tokens into array list
                    address.add(tokens[i]);

                if (tokens.length !=6) //Error message for incorrect field size
                    System.out.println("Error: Line does not have six fields!");

                /**Print to output file*/
                output.println(tokens[1] + " " + tokens[0] + "\n" + tokens[2] + "\n" + tokens[3] + " "
                        + tokens[4] + "\n");

                for (int i=0; i<tokens.length;i++) { //Unused word count to use for output
                    wordCount++;
                }
            }
        } catch (FileNotFoundException e) { //no file
            System.out.println("Source file not found.");
        }
        output.close(); //close file
    }
}


