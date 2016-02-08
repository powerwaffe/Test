package ProjectTest;
/**
 * Created by Sean on 2/1/2016.
 * Notes: Entries > 60 print null names
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Artist
{
    private String artistName;
    private int artistID;

    /** constructor for Artist*/
    public Artist(int ID, String artist)
    {
        setArtistID(artistID = ID);
        setArtistName(artistName = artist);
    } // end constructor

    /** toString method */
    public String toString()
    {
        return getArtistID() + " " + getArtistName();
    } // end toString

    /** getter for artist name*/
    private String getArtistName()
    {
        return artistName;
    } // end getArtistName

    /** setter for artist name*/
    private void setArtistName(String newName)
    {
        artistName = newName;
    } // end setArtistName

    /** getter for artist ID*/
    private int getArtistID()
    {
        return artistID;
    } // end getArtistID

    /** setter for artist ID*/
    private void setArtistID(int newID)
    {
        artistID = newID;
    } // end setArtistID

    public static void main(String[] args)
    {
        int artistCounter = 0; //counter for total artists
        String[] artistNameArray = new String[116]; //initialize artist name array
        try
        {
            Scanner input = new Scanner(new File("p1artists.txt"));
            File myFile = new File("p1artists_out1.txt");
            PrintWriter output = new PrintWriter(myFile);
            int i = 0; // loop counter
            while (input.hasNext())
            {
                artistCounter++;
                try
                {
                    int artistID = input.nextInt();
                    String artistName = input.next();
                    artistNameArray[i] = artistName;
                    output.println(artistID + " " + artistName);
                    i++; // increment counter
                }
                catch (InputMismatchException e)
                {
                    input.next();
                } // end catch
            } // end while loop
            output.close(); // close PrintWriter
            input.close(); // close Scanner
        } // end try
        catch (FileNotFoundException e)
        {
            System.out.println("No such file was found");
        } // end catch

        /**Write all to new file*/
        int j = 0; // to process array
        int artCounter = 0; // artwork counter
        int totalAppraised = 0; // total appraised
        try
        {
            Scanner input = new Scanner(new File("p1arts.txt"));
            File myFile = new File("p1arts_out.txt");
            PrintWriter output = new PrintWriter(myFile);
            while (input.hasNext())
            {
                try
                {
                    String[] splitArray = input.nextLine().split("\t"); // split string into an array
                    output.printf("%s\t%s\t%s\t%s\t%s\n", splitArray[0], splitArray[1],
                            splitArray[2], artistNameArray[j], splitArray[3]);
                    totalAppraised += Integer.parseInt(splitArray[3]); // sum of artwork
                    j++;
                    artCounter++;
                } // end try
                catch (InputMismatchException e)
                {
                    input.next();
                } // end catch
            } //end while loop
            output.close(); // close PrintWriter
            input.close(); // close Scanner
        } // end try
        catch (FileNotFoundException e)
        {
            System.out.println("No such file was found");
        } // end catch

        /**Totals*/
        int finalArtistCount = artistCounter-1;
        System.out.println("\nTotal artists: " + finalArtistCount);
        System.out.println("Total amount of artwork: " + artCounter);
        System.out.println("Total appraised value of all artwork: $" + totalAppraised);
    }
}

