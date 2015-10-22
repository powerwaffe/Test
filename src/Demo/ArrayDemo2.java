package Demo;
import java.util.Scanner;
/**
 * Created by Sean on 10/13/2015.
 */
public class ArrayDemo2 {
    public static void main(String[] ducks) {
        Scanner input = new Scanner(System.in);

        int[][] matrix = new int[2][2];

        System.out.println("Enter " + matrix.length + " rows and " + matrix[0].length + " columns: ");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column<matrix[row].length; column++) {
                matrix[row][column] = input.nextInt();
            }
        }
        int[][] newMatrix;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
               // newMatrix = matrix[row][column];
            }
            System.out.println();
        }
       // System.out.print("\nNew matrix is " +newMatrix);
    }
}
