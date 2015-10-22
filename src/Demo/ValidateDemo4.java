package Demo;

/**
 * Created by Sean on 10/12/2015.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ValidateDemo4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ShiftOne4.setup();
        ShiftTwo.setup();
        ShiftThree.setup();

        System.out.print("Enter your name: ");
        String name = input.next();

        boolean found = false;
        if (ShiftOne4.isShift(name)) {
            System.out.println("Please report for " + ShiftOne4.name);
            found = true;
        }

        if (ShiftTwo.isShift(name)) {
            System.out.println("Please report for " + ShiftTwo.name);
            found = true;
        }

        if (ShiftThree.isShift(name)) {
            System.out.println("Please report for " + ShiftThree.name);
            found = true;
        }

        if (!found)
            System.out.println("You are not assigned to any shift");
        input.close();
    }
}

abstract class ShiftOne4 {

    static ArrayList<String> workerList;
    static String[] workerArray = { "Larry", "Barry", "Harry" };
    static String name = "shift 1";

    public static void setup() {
        // Convert the workerArray into an ArrayList
        workerList = new ArrayList<>(Arrays.asList(workerArray));
    }

    // Test if a worker is on the ShiftOne ArrayList
    public static boolean isShift(String arg) {
        return (workerList.contains(arg)) ? true : false;
    }
}

abstract class ShiftTwo {

    static ArrayList<String> workerList;
    static String[] workerArray = { "Nick", "Nancy", "Niels" };
    static String name = "shift 2";

    public static void setup() {
        // Convert the workerArray into an ArrayList
        workerList = new ArrayList<>(Arrays.asList(workerArray));
    }

    // Test if a worker is on the ShiftTwo ArrayList
    public static boolean isShift(String arg) {
        return (workerList.contains(arg)) ? true : false;
    }
}

abstract class ShiftThree {

    static ArrayList<String> workerList;
    static String[] workerArray = { "Bob", "Bill", "Betty" };
    static String name = "shift 3";

    public static void setup() {
        // Convert the workerArray into an ArrayList
        workerList = new ArrayList<>(Arrays.asList(workerArray));
    }

    // Test if a worker is on the ShiftThree ArrayList
    public static boolean isShift(String arg) {
        return (workerList.contains(arg)) ? true : false;
    }
}