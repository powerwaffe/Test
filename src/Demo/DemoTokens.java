package Demo;

/**
 * Created by Sean on 10/13/2015.
 */
public class DemoTokens {
    public static void main(String[] ducks) {
        String sentence = "It was a dark & stormy night";

        String[] tokens = sentence.split(" ");

        System.out.println(tokens[0]);
    }
}
