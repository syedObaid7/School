/* Name: Syed Obaid Quadri
 * Date: 10/16/20
 * Description: This program will read in 5 numbers into an arraylist and sum them
 */

// Imports
import java.util.ArrayList;
import java.util.Scanner;

public class Q11_12
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // Create arraylist object
        ArrayList<Double> numbers = new ArrayList<>();

        // Read in 5 numbers
        System.out.println("Enter 5 numbers");

        for (int i = 0; i < 5; i++)
        {
            numbers.add(input.nextDouble());
        }

        System.out.println("The sum of the numbers is " + sum(numbers));
    }

    // Method will iterate through arraylist and add the value to variable sum and return sum
    public static double sum(ArrayList<Double> list)
    {
        double sum = 0;

        for (int i = 0; i < list.size(); i++)
        {
            sum += list.get(i);
        }

        return sum;
    }
}
