package Project4;

/**
 * Created by Sean on 2/24/2016.
 */

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 A class of stacks whose entries are stored in an array.
 @author Sean Paoli
 */
public class ArrayStack<T> implements StackInterface<T>
{
    private T[] stack;    // Array of stack entries
    private int topIndex; // Index of top entry
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public ArrayStack(int initialCapacity)
    {
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        initialized = true;
    } // end constructor

    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
                    "allowed maximum of " + MAX_CAPACITY);
    }
    /** add to stack */
    public void push(T newEntry)
    {
        checkInitialization();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    } // end push

    /** check capacity of array*/
    public void ensureCapacity()
    {
        if (topIndex == stack.length - 1)
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
    } // end ensureCapacity

    /** return top entry of stack */
    public T peek()
    {
        checkInitialization();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    } // end peek

    public T pop()
    {
        checkInitialization();
        if (isEmpty())
            throw new EmptyStackException();
        else {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }
    } // end pop

    public void clear()
    {
        for (int index = 0; index < stack.length; index++)
            stack[index] = null;
    } //end clear

    /** check array size */
    private boolean isArrayFull()
    {
        return topIndex >= stack.length;
    }

    public boolean isEmpty()
    {
        return topIndex < 0;
    }

    /** check if stack initialized */
    private void checkInitialization()
    {
        if (!initialized)
            throw new SecurityException ("Uninitialized object used " +
                    "to call an ArrayBag method.");
    } // end checkInitialization// end isArrayFull
//  < Implementations of the stack operations go here. >
//  < Implementations of the private methods go here; checkCapacity and
//    checkInitialization are analogous to those in Chapter 2. >
//  . . .
} // end ArrayStack
