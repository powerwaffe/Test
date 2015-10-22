package IntroToJavaDemo;
import java.io.IOException;

/**
 * Created by Sean on 10/11/2015.
 */
public class WriteData {
    public static void main(String[] duck) throws IOException {
        java.io.File file = new java.io.File("scores.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }

        /**Create file*/
        java.io.PrintWriter output = (new java.io.PrintWriter(file));

        /**Write formatted output to the file*/
        output.print("John T Smith ");
        output.println(90);
        output.print("Eric K Jones ");
        output.println(85);

        /**CLose the file*/
        output.close();
    }
}
