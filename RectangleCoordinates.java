/* Name: Syed Obaid Quadri
 * Date: 9/11/20
 * Description: This program will take in the center of two rectangles along with the width and length and check if
 *              one is inside another, if they overlap, or if they are identical
 */

// Imports
import java.util.Scanner;

public class Main_4
{

    public static void main(String[] args)
    {
        // Scanner for input
	    Scanner input = new Scanner(System.in);

	    // Read in center, length, and width for rectangle 1
        System.out.println("Enter r1's center x-, y-coordinates, width, and height: ");

        double firstX = input.nextDouble();
        double firstY = input.nextDouble();
        double firstHeight = input.nextDouble();
        double firstWidth = input.nextDouble();

        //  // Read in center, length, and width for rectangle 2
        System.out.println("Enter r2's center x-, y-coordinates, width, and height: ");

        double secondX = input.nextDouble();
        double secondY = input.nextDouble();
        double secondHeight = input.nextDouble();
        double secondWidth = input.nextDouble();

        // Calculate the range of rectangles
        double r1x_max = firstX + firstWidth;
        double r2x_max = secondX + secondWidth;
        double r1x_min = firstX - firstWidth;
        double r2x_min = secondX - secondWidth;
        double r1y_max = firstY + firstHeight;
        double r2y_max = secondY + secondHeight;
        double r1y_min = firstY - firstHeight;
        double r2y_min = secondY - secondHeight;

        // If conditions to check if the rectangles are identical, if they are inside one another, and whether they
        // overlap or not
        if (r1x_max == r2x_max && r1y_max == r1y_max && r1x_min == r2x_min && r1y_min == r2y_min)
        {
            System.out.println("r2 is identical to r1");
        } else if (r1x_max >= r2x_max && r1y_max >= r2y_max && r1x_min <= r2x_min && r1y_min <= r2y_min)
        {
            System.out.println("r2 is inside r1");
        } else if (r1x_max <= r2x_max && r1y_max <= r2y_max && r1x_min >= r2x_min && r1y_min >= r2y_min)
        {
            System.out.println("r1 is inside r2");
        } else if (r1x_max < r2x_min || r1y_max < r2y_min || r1x_min > r2x_max || r1y_min > r2y_max)
        {
            System.out.println("r2 does not overlap r1");
        }
        else
        {
            System.out.println("r2 overlaps r1");
        }
    }
}
