/* Name: Syed Obaid Quadri
 * Date: 10/30/2020
 * Description: This program will print the 5 entered strings in reverse order
 */

// Imports
import java.util.ArrayList;
import java.util.Scanner;

public class Q19_2
{
    // Main
    public static void main(String[] args)
    {
        // Scanner object
        Scanner input = new Scanner(System.in);

        // GenericStack object
        GenericStack<String> strings = new GenericStack<>();

        // Prompt user for input and place into stack
        System.out.println("Enter 5 strings");

        for (int i = 0; i < 5; i++)
        {
            strings.push(input.next());
        }

        // Print output
        while (!strings.isEmpty())
        {
            System.out.println(strings.pop());
        }
    }
}

/*
 ****************************************
 *              GenericStack<E>         *
 *--------------------------------------*
 * –list: java.util.ArrayList<E>        *
 *--------------------------------------*
 * +GenericStack()                      *
 * +getSize(): int                      *
 * +peek(): E                           *
 * +pop(): E                            *
 * +push(o: E): void                    *
 * +isEmpty(): boolean                  *
 * **************************************
 */

// A Generic Stack class that extends arraylist
class GenericStack<E> extends ArrayList<E>
{
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    /** Return the number of elements in the stack */
    public int getSize()
    {
        return list.size();
    }

    /** Return the element at the top of the stack */
    public E peek()
    {
        return list.get(getSize() - 1);
    }

    /** Push to the top of the stack */
    public void push(E o)
    {
        list.add(o);
    }

    /** Return and remove the top element from the stack */
    public E pop()
    {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    /** Test whether the stack is empty */
    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    @Override
    public String toString()
    {
        return "stack: " + list.toString();
    }
}
