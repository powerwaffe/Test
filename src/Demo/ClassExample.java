package Demo;

import java.util.Scanner;

/**
 * Created by Sean on 6/18/2016.
 */
public class ClassExample {
    public static void main(String[] farts ) {
        Scanner input = new Scanner(System.in);
        ClassExampleOne classExampleOne = new ClassExampleOne();
        String ex = classExampleOne.words;
        System.out.println("Current variable for String words is " + ex);
        System.out.println("Enter a new string for variable words");
        ex = input.next();
        System.out.println("New string for variable words is " + ex);
        System.out.println("Ok, so now enter a double...");
        classExampleOne.num1 = input.nextDouble();
        System.out.println("Enter a second double...");
        classExampleOne.num2 = input.nextDouble();
        System.out.println("Thanks, let me add" + classExampleOne.num1 + "and" + classExampleOne.num2
        + "together for you...");
        System.out.println("The answer is " + (classExampleOne.num1 + classExampleOne.num2));
        System.out.println("Hey here's a fun idea, let's change the words variable one more time!");
        ex = input.next();
        System.out.println("Wow, you changed the string to " + ex);

    }
}
class ClassExampleOne {
    String words = "farts";
    double num1 = 0;
    double num2 = 0;
}
