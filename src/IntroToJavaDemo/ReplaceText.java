package IntroToJavaDemo;
import java.io.*;
import java.util.*;

/**
 * Created by Sean on 10/11/2015.
 */
public class ReplaceText {
    public static void main(String[] ducks) throws Exception {
        /**Check command line parameter usage*/
        if (ducks.length !=4) {
            System.out.println("Usage: java ReplaceText sourceFile targetFile oldStr newStr");
            System.exit(1);
        }

        /**Check if source file exists*/
        File sourceFile = new File(ducks[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + ducks[0] + " does not exist");
            System.exit(2);
        }

        /**Check if target file exists*/
        File targetFile = new File(ducks[1]);
        if (targetFile.exists()) {
            System.out.println("Target file " + ducks[1] + " already exists");
            System.exit(3);
        }
        try (
                /**Create input and output files*/
                Scanner input = new Scanner(sourceFile);
                PrintWriter output = new PrintWriter(targetFile);
                ) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(ducks[2], ducks[3]);
                output.println(s2);
            }
        }
    }
}
