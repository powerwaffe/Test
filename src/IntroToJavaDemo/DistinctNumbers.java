package IntroToJavaDemo;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Created by Sean on 10/10/2015.
 */
public class DistinctNumbers {
    public static void main(String[] cheese) {
        ArrayList<Integer> list = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter integers (input ends with 0): ");
        int value;

        do {
            value = input.nextInt(); //read a value from the input

            if (!list.contains(value) && value != 0)
                list.add(value); //add the value if it is not in the list
        } while (value !=0);

        //display the distinct numbers
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i) + " ");
    }
}
