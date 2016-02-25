package ProjectTest2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Sean on 2/6/2016.
 * NOTES: There is a lot of unfinished code here. I am missing the no gap array, as well as the next field
 * array. Add delete field array is partially finished, and is missing its delete function.
 */
public class ProjectTwoArray
{
    int numberOfEntries; //entry total

    public static void main(String[] args)
    {
        ArrayList<String> entryArr = new ArrayList<>(); // array list for adding and removing
        String[] idArray = new String[82];

        int myIndexNum = 0; // used to print changed index according to add or delete
        boolean deleteField = false;
        String[] artistCompareArr = new String[8];

        // Method calls and timers
        long startTimeAddDel = System.nanoTime();
        changeFileA(1, "name");
        long endTimeAddDel = System.nanoTime();
        long durationAddDel = endTimeAddDel-startTimeAddDel;
        changeFileB(2, "name2");
        changeFileC(3, "name3");

        System.out.println("Add or delete array completed in: " + durationAddDel);

        /**TODO:Split integer into an array, use this integer to compare to another index array
         * This index should be compared after add or delete is found then...
         * if (index[0].equals(index2[0]))
         * print result with id name true or false
         * This comparison can show whether a marked index's integer matches the other
         * created index array
         */


        /**Starting file step 1 */
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
                    idArray[i] = nameName;
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

        /**Open changes file and load up arrays to compare */
        try
        {
            Scanner input = new Scanner(new File("p2changes.txt"));
            int index =0;
            while (input.hasNext())
            {
                String[] addOrDelete = input.nextLine().split("\t");
                if (addOrDelete[0].equals("A"))
                {
                    myIndexNum++; // increment to use as index
                    entryArr.add(myIndexNum + "\t" + addOrDelete[1]); //add new array elements
                    //idArray[index] = myIndexNum + "\t" + addOrDelete[1];
                }
                //Tried to implement delete conditional statement for arrayList
                if (addOrDelete[0].equals("D")) {
                    artistCompareArr[index] = (addOrDelete[1]); //index numbers to be deleted
                    index++;
                }
            }
            input.close();
            //output.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println();
        } // end catch

        /**Compare index for deletion*/
        /**Ideas: Get a third array that holds only index then compare that with artistCompareArr*/

            int indexCounter = 0; //count through array, if index+1 = artistCompareArr remove
            for (int index = 0; index < entryArr.size(); index++)
            {
            }

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

        entryArr.toArray(idArray);
        for (int index = 0; index < artistCompareArr.length; index++)
            System.out.println(artistCompareArr[index]);

        for (int index = 0; index < entryArr.size(); index++)
            System.out.println(entryArr.get(index));
    }

    //TODO: Create array without gap
    public static void changeFileA(int id, String name)
    {
        //STUB
        System.out.println(id + "\t" + name);


    }

    //TODO: Create array with delete field
    //Adds delete field, displaying true or false as a new parameter
    public static void changeFileB(int id, String name)
    {
        //STUB
        System.out.println(id + "\t" + name);
    }

    //TODO: Create array with next field
    //Next field points to the next available point in an array (1 points to 3 if index 2 is null)
    public static void changeFileC(int id, String name)
    {
        //STUB
        System.out.println(id + "\t" + name);
    }
}
