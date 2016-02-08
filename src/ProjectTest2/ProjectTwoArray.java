package ProjectTest2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Sean on 2/6/2016.
 * NOTES: There is alot of unfinished code here. I am missing the no gap array, as well as the next field
 * array. Add delete field array is partially finished, and is missing its delete function.
 */
public class ProjectTwoArray
{
    public static void main(String[] args)
    {
        ArrayList<String> entryArr = new ArrayList<>(); // array list for adding and removing
        int myIndexNum = 0; // used to print changed index according to add or delete
        long startTimeAddDel = System.nanoTime();

        try
        {
            Scanner input = new Scanner(new File("p2artists.txt"));
            File myFile = new File("p2artists2b3.txt");
            PrintWriter output = new PrintWriter(myFile);
            int i = 0; // loop counter
            while (input.hasNext())
            {
                try
                {
                    String nameName = input.nextLine();
                    entryArr.add(nameName);
                    i++; // increment counter
                    myIndexNum += 1; // sum index number to be used for printing
                }
                catch (InputMismatchException e)
                {
                    input.next();
                } // end catch
            } // end while loop
            input.close(); // close Scanner
            output.close();
        } // end try
        catch (FileNotFoundException e)
        {
            System.out.println("No such file was found");
        } // end catch

        /**Creates an array that holds the values for adding and deleting
         * Uses array list utils to append entries
         * TODO: Add deletion field
         */
        try
        {
            Scanner input = new Scanner(new File("p2changes.txt"));
            while (input.hasNext())
            {
                String[] addOrDelete = input.nextLine().split("\t");
                if (addOrDelete[0].equals("A"))
                {
                    myIndexNum++; // increment to use as index
                    entryArr.add(myIndexNum + "\t" + addOrDelete[1]); //add new array elements
                }
                //Tried to implement delete conditional statement for arrayList
                //if (addOrDelete[0].equals("D") && entryArr.contains(addOrDelete[1]))
                //entryArr.remove(entryArr);
            }
            input.close();
            //output.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println();
        } // end catch

        try
        {
            File myFile = new File("p2artists2b.txt");
            PrintWriter output = new PrintWriter(myFile);

            for (int i = 0; i < entryArr.size(); i++)
                output.println(entryArr.get(i));
            output.close(); // close printWriter
        } // end try
        catch (FileNotFoundException e)
        {
            System.out.println();
        } // end catch

        long endTimeAddDel = System.nanoTime();
        long durationAddDel = endTimeAddDel-startTimeAddDel;
        System.out.println("Add or delete array completed in: " + durationAddDel);
        /**Array Tester*/
        //System.out.println(bag.length);
         //for (int i = 0; i < entryArr.size(); i++)
         //System.out.println(entryArr.get(i));
    }
}
