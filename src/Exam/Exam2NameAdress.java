package Exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Sean Paoli
 * CIS 150-401
 * This program will take an input file and will modify it as well as print the
 * modified file to an output file.
 */
public class Exam2NameAdress {
    private static int wordCount;
    public static void main(String[] ducks) throws IOException {
        File file = new File("file_in.txt"); //create file object
        File fileOut = new File("file_out.txt"); //create output file object
        PrintWriter output = new PrintWriter(fileOut); //create printwriter object
        ArrayList<String> address = new ArrayList<>(); //create arrayList

        try {
            Scanner input = new Scanner(file);

            while (input.hasNext()) {

                String line = input.nextLine();
                String[] tokens = line.split(";|;;");

                for (int i=0; i < tokens.length;i++) //load tokens into array list
                    address.add(tokens[i]);

                //System.out.println("ArrayList size " +address.size());
                //System.out.println("Token length " + tokens.length);

                if (tokens.length !=6) //Error message for incorrect field size
                    System.out.println("Error: Line does not have six fields!");

                // System.out.println(wordCount);

                output.println(tokens[1] + " " + tokens[0] + "\n" + tokens[2] + "\n" + tokens[3] + " "
                        + tokens[4] + "\n");

                for (int i=0; i<tokens.length;i++) {
                    wordCount++;
                }
                if (address.isEmpty())
                    address.clear();

            }
            System.out.println(address);

            System.out.println("Word count is " + wordCount);

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found.");
        }
        output.close();
    }
}
