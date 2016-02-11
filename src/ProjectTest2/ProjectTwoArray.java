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
    int numberOfEntries; //entry total
    String[] bag;
    public static void main(String[] args)
    {
        ArrayList<String> entryArr = new ArrayList<>(); // array list for adding and removing
        String[] artistArray;
        int myIndexNum = 0; // used to print changed index according to add or delete
        boolean deleteField = false;
        int indexIncrement = 1; //initialize
        int[] indexArray = new int[indexIncrement]; //load index to be compared

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
                    //int idNumber = input.nextInt();
                    //indexArray[i]= idNumber;
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
            int index =0;
            while (input.hasNext())
            {
                String[] addOrDelete = input.nextLine().split("\t");
                if (addOrDelete[0].equals("A"))
                {
                    myIndexNum++; // increment to use as index
                    entryArr.add(myIndexNum + "\t" + addOrDelete[1] + "\tFalse"); //add new array elements
                }
                //Tried to implement delete conditional statement for arrayList
                if (addOrDelete[0].equals("D"))
                entryArr.add(addOrDelete[1] + "\t\tTrue");

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

        for (int index = 0; index < indexArray.length; index++)
            System.out.println(indexArray[index]);
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

    public boolean remove(String anEntry)
    {
        int index = getIndexOf(anEntry);
        String result = removeEntry(index);
        return anEntry.equals(result);
    } // end remove

    private int getIndexOf(String anEntry)
    {
        int where = -1;
        boolean found = false;
        int index = 0;

        while (!found && (index < numberOfEntries))
        {
            if (anEntry.equals(bag[index]))
            {
                found = true;
                where = index;
            } // end if
            index++;
        } // end while

        // Assertion: If where > -1, anEntry is in the array bag, and it
        // equals bag[where]; otherwise, anEntry is not in the array.

        return where;
    } // end getIndexOf

    private String removeEntry(int givenIndex)
    {
        String result = null;

        if (givenIndex >= 0)
        {
            result = bag[givenIndex];          // Entry to remove
            int lastIndex = numberOfEntries - 1;
            bag[givenIndex] = bag[lastIndex];  // Replace entry to remove with last entry
            bag[lastIndex] = null;             // Remove reference to last entry
            numberOfEntries--;
        } // end if

        return result;
    } // end removeEntry
}
