package Demo;

/**
 * Created by Sean on 10/13/2015.
 */
public class ArrayDemo1 {
    public static void main(String[] ducks) {
        int[][] scores = new int[3][4];
        //int[][] scores = {{2,3,4}, {5,6,7}};

        System.out.println("array size in rows is " + scores.length);
        System.out.println("array size in columns is " + scores[0].length);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j< 4; j++)
                scores[i][j] = i * j + 5;

        System.out.println("scores[i][j]");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j< 4; j++)
                System.out.println(scores[i][j]);

        /**Start index for loop if you want to skip tags*/
        //int i =0;
        //for (int j =1; j < 3; j++
        //System.out.println(scores[i][j]);
    }
}
