/* Name: Syed Obaid Quadri
 * Date: 10/16/20
 * Description: This program will read in 5 numbers into an arraylist and sort it in ascending order
 */

// Imports

import java.util.ArrayList;
import java.util.Scanner;

public class Q11_11
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // Create arraylist object
        ArrayList<Integer> numbers = new ArrayList<>();

        // Read in 5 numbers
        System.out.println("Enter 5 numbers");

        for (int i = 0; i < 5; i++)
        {
            numbers.add(input.nextInt());
        }

        // Method call
        sort(numbers);

        System.out.println(numbers.toString());
    }

    // Method will sort arraylist
    public static void sort(ArrayList<Integer> list)
    {
        for (int i = 0; i < list.size() - 1; i++)
        {
            int low = list.get(i);
            int index = i;

            for (int j = i + 1; j < list.size(); j++)
            {
                if (low > list.get(j))
                {
                    low = list.get(j);
                    index = j;
                }
            }

            if (index != i)
            {
                list.set(index, list.get(i));
                list.set(i, low);
            }
        }
    }
}
