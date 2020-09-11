/* Name: Syed Obaid Quadri
 * Date: 9/8/20
 * Description: This program will check if the entered coordinate is
 *              within a circle centered at (0,0) with a radius of 10
 */

// Imports
import java.util.Scanner;

public class Main_3
{
    public static void main(String[] args)
    {
        // Scanner to read in coordinates
        Scanner input = new Scanner(System.in);

        // Ask user to input coordinates
        System.out.println("Enter a point with two coordinates:");
        double pointX = input.nextDouble();
        double pointY = input.nextDouble();

        // Calculate distance from center (0,0)
        double distance = Math.pow((Math.pow((pointX - 0), 2) + Math.pow((pointY - 0), 2)), 0.5);

        // Checks whether distance is less than or equal to the radius. If its <= then it is in the circle
        if (distance <= 10)
        {
            System.out.println("Point (" + pointX + "," + pointY + ") is in the circle");
        } else
        {
            System.out.println("Point (" + pointX + "," + pointY + ") is not in the circle");
        }
    }
}
