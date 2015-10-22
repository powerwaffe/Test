package FileIODemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Sean on 10/6/2015.
 */
public class FileOutpuDemo {
    public static void main(String[] duck) throws FileNotFoundException {

        try {
            File myFile = new File("output.txt");
            PrintWriter output = new PrintWriter(myFile);

            output.println("HEADING");
            for (int i =1 ; i<=10; i++)
                output.print(i+" ");
            System.out.println("\n");

            output.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
