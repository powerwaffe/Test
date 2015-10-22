package Demo;
import java.util.Scanner;
/**
 * Created by Sean on 10/1/2015.
 */
public class TryCatchDemo {

    public static void main(String[] anus) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input integer: ");
        String response = input.nextLine();

        try {
            int i = Integer.parseInt(response);
            System.out.println("Integer input = " + i);
        } catch (NumberFormatException e) {
            System.out.println("ERROR! You were supposed to enter an integer");
        }
        input.close();
    }
}
