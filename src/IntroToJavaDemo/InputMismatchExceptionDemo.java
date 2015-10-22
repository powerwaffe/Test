package IntroToJavaDemo;
import java.util.*;
/**
 * Created by Sean on 10/12/2015.
 */
public class InputMismatchExceptionDemo {
    public static void main(String[] ducks) {
        Scanner input = new Scanner(System.in);
        boolean continueInput = true;

        do {
            try {
                System.out.println("Enter an integer: ");
                int number = input.nextInt();

                //display result
                System.out.println("The number entered is " + number);
                continueInput = false;
            }catch (InputMismatchException ex) {
                System.out.println("try again. (" + "Incorrect input: and integer is required)");
                input.nextLine(); //Discard input
            }
        } while (continueInput);
    }
}
