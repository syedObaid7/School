/*
 * Name: Syed Obaid Quadri
 * Date: 9/8/20
 * Description: This program will print the ISBN-10 after given the first 9 digits
 */

// Imports required
import java.util.Scanner;

public class Main_2
{

    public static void main(String[] args)
    {
        // Scanner to read input
        Scanner input = new Scanner(System.in);

        // Read in 9 digits
        System.out.println("Enter the first 9 digits of an ISBN as integer: ");
        int isbn = input.nextInt();

        // Lines 22-48 will place each of the 9 digits into an int variable by performing a series of operations
        int d9 = (isbn % 10);
        isbn /= 10;

        int d8 = (isbn % 10);
        isbn /= 10;

        int d7 = (isbn % 10);
        isbn /= 10;

        int d6 = (isbn % 10);
        isbn /= 10;

        int d5 = (isbn % 10);
        isbn /= 10;

        int d4 = (isbn % 10);
        isbn /= 10;

        int d3 = (isbn % 10);
        isbn /= 10;

        int d2 = (isbn % 10);
        isbn /= 10;

        int d1 = isbn % 10;
        isbn /= 10;

        // Calculate the checksum value (used to determine the 10th digit
        int checkSum = ((d1 * 1) + (d2 * 2) + (d3 * 3) + (d4 * 4)+ (d5 * 5) +
                        (d6 * 6) + (d7 * 7) + (d8 * 8) + (d9 * 9)) % 11;

        // Print the ISBN-10
        System.out.print("The ISBN-10 is " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9);

        // Checks the value of checksum and prints
        if (checkSum == 10)
        {
            System.out.println("X");
        } else
        {
            System.out.println(checkSum);
        }
    }
}
