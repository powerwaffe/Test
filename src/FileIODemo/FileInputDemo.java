package FileIODemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileInputDemo {
    public static void main(String[] bucket) {

            try {
                // File myFile = new File("data_txt");
                Scanner bob = new Scanner(new File("gradeBook.txt"));
                while (bob.hasNext()) {
                    try {
                        int mine = bob.nextInt();
                        System.out.println("Integer read is: " + mine);
                    } catch (InputMismatchException e) {
                       // System.out.println("Non-integer data was read");
                        bob.next();
                    }
                }
                bob.close();

            } catch (FileNotFoundException e) {
                System.out.println("Failed to open file " + e.getMessage());
            }
        }
    }









