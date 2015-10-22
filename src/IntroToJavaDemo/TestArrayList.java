package IntroToJavaDemo;
import java.util.ArrayList;
/**
 * Created by Sean on 10/12/2015.
 */
public class TestArrayList {
    public static void main(String[] ducks) {
        /**Create a list to store cities*/
        ArrayList<String> cityList = new ArrayList<>();

        /**Add cities to list*/
        cityList.add("London");
        cityList.add("Denver");
        cityList.add("Paris");
        cityList.add("Miami");
        cityList.add("Seoul");
        cityList.add("Tokyo");

        System.out.println("List size? " + cityList.size());
        System.out.println("Is miami in the list? " + cityList.contains("Miami"));
        System.out.println("The location of Denver in the list? " + cityList.indexOf("Denver"));
        System.out.println("Is the list empty? " + cityList.isEmpty()); //print false

        /**Insert new city at index 2 or [2]*/
        cityList.add(2, "Xian");

        /**Remove a city from the list*/
        cityList.remove("Miami");

        /**Remove city at index 1 or (1)*/
        cityList.remove(1);

        /**Display the contents in the list*/
        System.out.println(cityList.toString());

        /**Display the contents in the list in reverse order*/
        for (int i = cityList.size()-1; i>=0; i--)
            System.out.print(cityList.get(i) + " ");
        System.out.println();

    }
}
