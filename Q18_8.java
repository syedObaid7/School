/* Name: Syed Obaid Quadri
 * Date: 10/28/2020
 * Description: This program will print a number backwards using recursion
 */

// Imports
import java.util.Scanner;

public class Q18_8
{
    // Main
    public static void main(String[] args)
    {
        // Scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number");

        // Method call
        reverseDisplay(input.nextInt());
    }

    // Prints number backwards
    public static void reverseDisplay(int value)
    {
        if (value != 0)
        {
            System.out.print(value % 10);
            value = value / 10;
            reverseDisplay(value);
        }
    }
}
