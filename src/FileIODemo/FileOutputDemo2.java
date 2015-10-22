package FileIODemo;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
/**
 * Created by Sean on 10/8/2015.
 */
public class FileOutputDemo2 {
    public static void main(String[] ravioli) {
        //*Note that setting the second parameter true
        // opens the file in append mode

        try {
            FileWriter myFile = new FileWriter("output.txt", true);
            PrintWriter output = new PrintWriter(myFile);

            output.println("\nHeading");
            for (int i=1; i<=10;i++)
                output.print(i+" ");

            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
