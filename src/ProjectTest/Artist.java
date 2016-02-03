package ProjectTest;

/**
 * Created by Sean on 2/1/2016.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Created by Sean on 2/1/2016.
 */

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
        //Array list to be loaded
        ArrayList artistArrayList = new ArrayList();

        //String[] myArr = new String[120];
        int counter = 0; //counter for lines

        /**maybe create dummy array list with large size ex. arr[300]*/

        try {
            Scanner art = new Scanner(new File("p1artists.txt"));
            //File myFile = new File("p1artists_out1.txt");
            //PrintWriter output = new PrintWriter(myFile);

            while (art.hasNext()) {
                // artistArrList.add(art.next()); //load p1artists.txt into artistArrList
                artistArrayList.add(art.nextLine());
                //nameArray.add(art.nextLine());
                try {
                    // counter++; //counter
                    // int artist = art.nextInt();
                    //String name = art.next();
                    //output.println(artist + " " + name);
                    //output.println(artistArrList.toString());
                    //output.println(idarray.toString());
                } catch (InputMismatchException e) {
                    art.next();
                    //output.close();
                }
            }
            art.close();
        } catch (FileNotFoundException e) {
            System.out.println("No such file was found");
        }

        //e.printStackTrace();

        // Artist[] items = {new Artist(1, "Acconci"),
        //   new Artist(2, "Ames"),
        // new Artist(3, "Aserty"),
        //  new Artist(4, "Baron"),
        //   new Artist(5, "Battenberg")};
        //for (int i = 0; i < items.length; i++)
        //System.out.println(items[i]);
        //  for (int i=0; i < artistArrList.size(); i++)
        // {
        // System.out.println(artistArrList);

        /**Array tester*/
        for (int i = 0; i < artistArrayList.size(); i++)
            System.out.print(artistArrayList.get(i).toString() + "\n");

        /**Print to file*/
        try {
            //Scanner art = new Scanner(new File("p1artists.txt"));
            File myFile = new File("p1artists_out1.txt");
            PrintWriter output = new PrintWriter(myFile);

            for (int i = 0; i < artistArrayList.size(); i++)
                output.println(artistArrayList.get(i).toString());
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } // end Artist
}
