package Demo;

/**
 * Created by Sean on 10/12/2015.
 */
public class MultiDimArrayDemo {
    static int row;
    static int column;
    static int total;

    public static void main(String[] ducks) {


        int[][] matrix = new int[4][4];
        //for (int i = 0; i < 10; i++)
            //matrix[1][2] = 3;

        //System.out.println(matrix.length);
        total = 0;
        for (column = 0; column < matrix[0].length; column++) {
            //total = 0;
            for (row = 0; row < matrix.length; row++) {
                total += matrix[row][column];
                //matrix[column][row] = 2;

            }
            System.out.println("Sum for column " + column + " is " + total);
            System.out.println(matrix[1][2]);
        }
    }
}
