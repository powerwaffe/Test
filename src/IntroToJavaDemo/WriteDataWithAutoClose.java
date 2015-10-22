package IntroToJavaDemo;

/**
 * Created by Sean on 10/11/2015.
 */
public class WriteDataWithAutoClose {
    public static void main(String[] duck) throws Exception {
        java.io.File file = new java.io.File("scores2.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }

        try (
            /**Create File*/
            java.io.PrintWriter output = new java.io.PrintWriter(file);
        ) {
            /**Write formatted output to the file*/
            output.print("John T Smith");
            output.println(90);
            output.print("Eric K Jones");
            output.println(85);
        }
    }
}
