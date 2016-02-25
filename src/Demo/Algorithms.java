package Demo;

/**
 * Created by Sean on 2/16/2016.
 */
public class Algorithms {
    public static void main(String[] ducks) {
        //Change n to show greater or less time differences between algorithm A,B, and C
        long n = 100000;

        long startTimeAddDel1 = System.nanoTime();
        algA(n);
        long endTimeAddDel1 = System.nanoTime();

        long startTimeAddDel2 = System.nanoTime();
        algB(n);
        long endTimeAddDel2 = System.nanoTime();

        long startTimeAddDel3 = System.nanoTime();
        algC(n);
        long endTimeAddDel3 = System.nanoTime();

        long durationAddDel1 = endTimeAddDel1-startTimeAddDel1;
        long durationAddDel2 = endTimeAddDel2-startTimeAddDel2;
        long durationAddDel3 = endTimeAddDel3-startTimeAddDel3;

        System.out.println("Algorithm A took: " + durationAddDel1 + " nanoseconds");
        System.out.println("Algorithm B took: " + durationAddDel2 + " nanoseconds");
        System.out.println("Algorithm C took: " + durationAddDel3 + " nanoseconds");
    }

    public static void algA(long n)
    {
        long sum = 0;
        System.out.println("Algorithm A");
        for (long i = 1; i <= n; i++)
            sum = sum + i;
        System.out.println(sum);
    }

    public static void algB(long n)
    {
        long sum = 0;
        System.out.println("Algorithm B");
        sum = 0;
        for (long i = 1; i <= n; i++)
        {
            for (long j = 1; j <= i; j++)
                sum = sum + 1;
        }
        System.out.println(sum);
    }

    public static void algC(long n)
    {
        long sum = 0;
        System.out.println("Algorithm C");
        sum = n * (n + 1) / 2;
        System.out.println(sum);
    }
}
