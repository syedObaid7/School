/* Name: Syed Obaid Quadri
 * Date: 10/30/2020
 * Description: This program will convert a decimal number to binary using recursion
 */

// Imports
import java.util.Scanner;

public class Q18_21
{
    // Main
    public static void main(String[] args)
    {
        // Scanner object
        Scanner input = new Scanner(System.in);

        // Ask user for number and call dec2Bin method
        System.out.println("Enter a number");
        System.out.println(dec2Bin(input.nextInt()));
    }

    // This method will recursively return the binary value of a number
    public static String dec2Bin(int value)
    {
        if (value != 0)
        {
            int a = value / 2;
            int b = value % 2;

            return dec2Bin(a) + "" + (b);
        } else
        {
            return "";
        }
    }
}
