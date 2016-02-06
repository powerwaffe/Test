package ProjectTest;

/**
 * Created by Sean on 2/1/2016.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Artist {
    private String artistName;
    private int artistID;

    public Artist(int ID, String artist) {
        artistID = ID;
        artistName = artist;
    } // end constructor

    public String toString() {
        return getArtistID() + " " + getArtistName();
    } // end toString

    private String getArtistName() {
        return artistName;
    } //end getArtistName

    private void setArtistName(String newName) {
        artistName = newName;
    } //end setArtistName

    private int getArtistID() {
        return artistID;
    } //end getArtistID

    private void setArtistID(int newID) {
        artistID = newID;
    } //end setArtistID

    /**
     * MODIFY TO DETECT INCORRECT ID
     */
    public static void main(String[] args) {
        ArrayList<String> tokens = new ArrayList<>();
        ArrayList<String> artistArrName = new ArrayList<>();
        int counter = 0; //counter for lines
        String[] arrayTry = new String[116];

        try
        {
            Scanner input = new Scanner(new File("p1artists.txt"));
            File myFile = new File("p1artists_out1.txt");
            PrintWriter output = new PrintWriter(myFile);
            int ccc=0;
            while (input.hasNext())
            {
                counter++;
                try
                {
                    int artistID = input.nextInt();
                    String artistName = input.next();
                    arrayTry[ccc] = artistName;
                    output.println(artistID + " " + artistName);
                    System.out.println(artistID + " " + artistName);
                    ccc++;
                }
                catch (InputMismatchException e)
                {
                    input.next();
                }
            }
            output.close(); //close PrintWriter
            input.close(); //close Scanner
        } //end try
        catch (FileNotFoundException e)
        {
            System.out.println("No such file was found");
        } //end catch

        try
        {
            Scanner input = new Scanner(new File("p1artists.txt"));

            while (input.hasNext())
            {
                tokens.add(input.next());
            }
        } //end try
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } //end catch

        /**Write all to new file*/
        int loop = 1;
        int artCounter = 0;
        try
        {
            Scanner input = new Scanner(new File("p1arts.txt"));
            File myFile = new File("p1arts_out.txt");
            PrintWriter output = new PrintWriter(myFile);
            while (input.hasNext()) {
                try {
                    int art = input.nextInt();
                    String names = input.nextLine();
                    output.println(art + names + "\t" + arrayTry[loop-1] + "\n");
                    loop++;
                    artCounter++;

                } catch (InputMismatchException e) {
                    input.next();
                }
            }
            output.close(); //close PrintWriter
            input.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("No such file was found");
        }

        /**Array tester*/
        int newCounter = counter-1;
        System.out.println("\nAmount of artists " + newCounter);
        System.out.println("Total amount of artwork " + artCounter);

        /**Array tester*/
        //System.out.println("Array contents:\n");
        for (int i = 0; i< arrayTry.length; i++)
            System.out.println(arrayTry[i]);

        System.out.println(arrayTry.length);
    }
}

