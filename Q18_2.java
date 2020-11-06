/* Name: Syed Obaid Quadri
 * Date: 10/27/20
 * Description: This program will print the fibonacci number given its index
 */

// Imports
import java.util.Scanner;

// Main
public class Q18_2
{
    public static void main(String[] args)
    {
        // Scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an index");
        long index = input.nextLong();

        // Call and print method
        System.out.println(fib(index));
    }

    public static long fib(long index)
    {
        long f0 = 0; // For fib(0)
        long f1 = 1; // For fib(1)
        long currentFib = 0;

        if (index == 0) // Base case
        {
            return 0;
        } else if (index == 1) // Base case
        {
            return 1;
        } else // Reduction and recursive calls
        {
            for (int i = 1; i < index; i++)
            {
                currentFib = f0 + f1;
                f0 = f1;
                f1 = currentFib;
            }
            return currentFib;
        }
    }
}
