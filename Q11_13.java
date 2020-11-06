/* Name: Syed Obaid Quadri
 * Date: 10/16/20
 * Description: This program will read in 10 numbers into an arraylist and remove any duplicates
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Q11_13
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // Create arraylist object
        ArrayList<Integer> numbers = new ArrayList<>();

        // Read in 10 numbers
        System.out.println("Enter 10 numbers");

        for (int i = 0; i < 10; i++)
        {
            numbers.add(input.nextInt());
        }

        // Call method
        removeDuplicate(numbers);

        // Print arraylist
        System.out.println(numbers.toString());

    }

    // This method will check if any element is the same as any element after it and remove the 2nd element if true
    public static void removeDuplicate(ArrayList<Integer> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = 1 + i; j < list.size(); j++)
            {
                if (list.get(i) == list.get(j))
                {
                    list.remove(j);
                }
            }
        }
    }
}
