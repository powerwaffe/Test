package ProjectTest2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Sean on 2/6/2016.
 */
public class ProjectTwoArray
{
    public static void main(String[] args)
    {
        ArrayList<String> deleteField = new ArrayList<>();
        String[] entryArray = new String[60]; //initialize artist name array
        try
        {
            Scanner input = new Scanner(new File("p2artists.txt"));
            int i = 0; // loop counter
            while (input.hasNext())
            {
                //artistCounter++;
                try
                {
                    //int artistID = input.nextInt();
                    String log = input.nextLine();
                    entryArray[i] = log;
                    //System.out.println(entryArray[i]);
                    i++; // increment counter
                }
                catch (InputMismatchException e)
                {
                    input.next();
                } // end catch
            } // end while loop
            input.close(); // close Scanner
        } // end try
        catch (FileNotFoundException e)
        {
            System.out.println("No such file was found");
        } // end catch


        try
        {
            int j =0;
            Scanner input = new Scanner(new File("p2changes.txt"));
            while (input.hasNext())
            {
                String[] addOrDelete = input.nextLine().split("\t");
                //System.out.println(addOrDelete[0]);
                //System.out.println(myArray[j]);

                if (addOrDelete[0].equals("A")) {
                   // System.out.println("Add this entry " + addOrDelete[0]);
                    //System.out.println(myArray[i]);
                }
                else
                    System.out.println();
            }
            input.close();
        }
        catch (FileNotFoundException e) {
            System.out.println();
        }

        /**Array Tester*/
        for (int i = 0; i < entryArray.length; i++)
            System.out.println(entryArray[i]);
    }
}
