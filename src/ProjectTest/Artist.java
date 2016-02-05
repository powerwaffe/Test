package ProjectTest;

/**
 * Created by Sean on 2/1/2016.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

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
        //ArrayList artistArrayList = new ArrayList();
        ArrayList<Object> tokens = new ArrayList<>();
        ArrayList<String> artistArrName = new ArrayList<>();
        //String[] myArr = new String[120];
        int counter = 0; //counter for lines

        /**maybe create dummy array list with large size ex. arr[300]*/

        try {
            Scanner input = new Scanner(new File("p1artists.txt"));
            File myFile = new File("p1artists_out1.txt");
            PrintWriter output = new PrintWriter(myFile);

            while (input.hasNext()) {
                // artistArrList.add(art.next()); //load p1artists.txt into artistArrList
                counter++;
                //nameArray.add(art.nextLine());
                try {
                    int artistID = input.nextInt();
                    String artistName = input.next();
                    output.println(artistID + " " + artistName);
                    System.out.println(artistID + " " + artistName);
                } catch (InputMismatchException e) {
                    input.next();
                   // output.close(); //close PrintWriter
                }
            }
            output.close(); //close PrintWriter
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("No such file was found");
        }


        try {
            Scanner input = new Scanner(new File("p1artists.txt"));
            File myFile = new File("p1arts_out.txt");
            PrintWriter output = new PrintWriter(myFile);

            while (input.hasNext())
            {
                tokens.add(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /**Write all to new file*/
        try {
            Scanner input = new Scanner(new File("p1arts.txt"));
            File myFile = new File("p1arts_out.txt");
            PrintWriter output = new PrintWriter(myFile);

            while (input.hasNext()) {
                try {
                    String artwork = input.next();

                    output.println(artwork);
                    for (int i =0; i < tokens.size(); i++)
                        output.println(tokens.get(i));
                } catch (InputMismatchException e) {
                    input.next();
                    // output.close(); //close PrintWriter
                }
            }
            output.close(); //close PrintWriter
            input.close();
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
        //for (int i = 0; i < artistArrayList.size(); i++)
        //   System.out.print(artistArrayList.get(i).toString() + "\n");
        int newCounter = counter-1;
        System.out.println("\nAmount of artists " + newCounter);
        //String[] tokenArray = tokens.toArray(new String[0]);

        /**Array tester*/
        System.out.println("Array contents:\n");
        for (int i = 0; i< tokens.size(); i++)
        System.out.println(tokens.get(i));
          //  System.out.println(tokenArray[i]);
        //System.out.println(artistArray.length);
        /**Print to file*/
       // try {
           // Scanner input = new Scanner(new File("p1artists.txt"));
          //  while (input.hasNext())
        //    {
           //    artistArray[counter-1]= input.nextLine();
         //   }

      //  } catch (FileNotFoundException e) {
        //    e.printStackTrace();
      //  }
      //  System.out.println("My array!");
        //for (int i=0;i<artistArray.length;i++)
           // System.out.println(artistArray[i]);
    }
}

