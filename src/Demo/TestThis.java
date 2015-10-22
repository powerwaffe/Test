package Demo;
import java.util.Scanner;

/**
 * Created by Sean on 9/8/2015.
 */
public class TestThis {
    public static void main(String[] args) {
        System.out.println("I am a crazy man and nobody knows!");
        System.out.println("--------------------------------------");
        Scanner input = new Scanner(System.in);
        System.out.println("Type in character");
        String character = input.next();
        System.out.println("Your character is " + character + " \nnow " + character + "uck off");
    }
}