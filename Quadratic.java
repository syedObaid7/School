/*
 * Name: Syed Obaid Quadri
 * Date: 9/8/20
 * Description: The program will read in 3 values from the user which
 *              will be used to calculate the roots of a quadratic equation
 */

// Imports for program
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main_1
{

    public static void main(String[] args)
    {
        // Scanner to read input
        Scanner input = new Scanner(System.in);

        // Decimal format for first and second root
        DecimalFormat format1 = new DecimalFormat("0.######");
        DecimalFormat format2 = new DecimalFormat("0.#####");


        // Create variables
        double a, b, c;

        // Ask user to enter the values for a, b, and c
        System.out.println("Enter a, b, c: ");
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();

        // Calculate discriminant to figure out how many roots exist
        double discriminant = (b * b) - (4 * a * c);

        // Calculate the 2 roots using the quadratic equation
        double r1 = ((-b) + Math.pow(discriminant, 0.5)) / (2 * a);
        double r2 = ((-b) - Math.pow(discriminant, 0.5)) / (2 * a);

        // Print the roots based on the value of the discriminant
        if (discriminant > 0)
        {
            System.out.println("The equation has two roots " + format1.format(r1) + " " + format2.format(r2));
        } else if (discriminant == 0)
        {
            System.out.println("The equation has one root " + r1);
        } else
        {
            System.out.println("The equation has no real roots");
        }
    }
}
