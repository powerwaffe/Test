package Demo;

/**
 * Created by Sean on 10/12/2015.
 */
public class DemoArray {

    public static void main(String[] duck) {
        String[] duckNumArr = {"3"};

        int[] results = new int[duckNumArr.length];

    for (int i =0; i <duckNumArr.length; i++) {
        results[i] = Integer.parseInt(duckNumArr[i]);
    }
        System.out.println(results.toString());

      //  System.out.println(newDuckNum);
    }

    public String toString() {
        return "Integers are " ;
    }
}
