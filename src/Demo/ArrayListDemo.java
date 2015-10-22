package Demo;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Created by Sean on 10/1/2015.
 */
public class ArrayListDemo {

   public static void main(String[] duck) {
       ArrayList<Integer> myList1 = new ArrayList<>();
       ArrayList<String> myList2 = new ArrayList<>();

       myList1.add(42);
       myList1.add(27);
       myList1.add(-1);

       myList2.add("Fart");
       myList2.add("Feet");
       myList2.add("Apples");

       System.out.println(myList1.size());
       System.out.println(myList1);

       System.out.println(myList2);

       for (Integer each : myList1)
           System.out.println(each);

       System.out.println("Minimum value = " + Collections.min(myList1));
       Collections.sort(myList1);
       System.out.println(myList1);

       for (int i =0;i<5;i++) {
           Collections.shuffle(myList1);
           System.out.println(myList1);
       }
       System.out.println();

       for (int i=0;i<3;i++) {
           Collections.shuffle(myList2);
           System.out.println(myList2);
       }
   }
}
