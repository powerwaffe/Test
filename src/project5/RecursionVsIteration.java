package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Sean on 2/28/2016.
 */
public class RecursionVsIteration {
    /** Driver method */
    public static void main(String[] args) throws FileNotFoundException {
        try {
            File myFile = new File("p4Out(Paoli,Sean).txt");
            PrintWriter output = new PrintWriter(myFile);


            // recursive factorial
            long startTime = System.nanoTime(); // starting timer to be used for all four methods
            output.println("***************Recursive Factorial***************");
            for (int i = 0; i < 20; i++)
               output.println(i + " = " + factorial(i));
            long stopTime = System.nanoTime(); // end timer to be used for all four methods
            output.println("Time to complete: " + (stopTime - startTime + " ms\n"));

            // non-recursive factorial
            startTime = System.nanoTime();
            output.println("***************Non-Recursive Factorial***************");
            for (int i = 0; i < 20; i++)
                output.println(i + " = " + nFactorial(i));
            stopTime = System.nanoTime();
            output.println("Time to complete: " + (stopTime - startTime + " ms\n"));

            // recursive fibonacci
            startTime = System.nanoTime();
            output.println("***************Recursive Fibonacci***************");
            for (int i = 0; i < 20; i++)
                output.println(i + " = " + fibonacci(i));
            stopTime = System.nanoTime();
            output.println("Time to complete: " + (stopTime - startTime + " ms\n"));

            // non-recursive fibonacci
            startTime = System.nanoTime();
            output.println("***************Non-Recursive Fibonacci***************");
            for (int i = 0; i < 20; i++)
                output.println(i + " = " + nFibonacci(i));
            stopTime = System.nanoTime();
            output.println("Time to complete: " + (stopTime - startTime + " ms\n"));
            output.close(); // close file
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /** Recursive method for factorial */
    public static long factorial(long n)
    {
        if (n >= 1)
        {
            return n * (nFactorial(n - 1)); // return recursive value
        } else
            return 1; // return 1 if less than 1
    } // end nFactorial

    /** Non-recursive method for factorial */
    public static long nFactorial(long n)
    {
        long result = 1;  // store result of factorial
        // loop to calculate factorial
        for (int i = 1; i <= n; i++)
        {
            result *= i;
        } // end loop
        return result;
    } // end factorial

    /** Recursive fibonacci method */
    public static int fibonacci(int n)
    {
        if (n == 0)
        {
            return 0;
        }
        else if (n <= 1)
        {
            return 1;
        }
        else
        {
            // calculate fibonacci
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    } // end fibonacci

    /** Non-recursive fibonacci method */
    public static int nFibonacci(int n)
    {
        int fib = 0;
        int a = 1;
        int temp;
        for(int i=0; i<=n; i++)
        {
            temp = fib;
            //fib = fib + a;
            fib = fib + a;
            a = temp;
        }
        return a;
    }
}



