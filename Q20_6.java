/* Name: Syed Obaid Quadri
 * Date: 11/8/2020
 * Description: This program will calculate the time taken to traverse through a linked list
 *              using an iterator and get(index)
 */

// Imports
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Q20_6
{
    // Main
    public static void main(String[] args)
    {
        // Create arraylist
        List<Integer> arrayList = new ArrayList<>();

        // Fill arraylist
        for (int i = 0; i < 5000000; i++)
        {
            arrayList.add(i);
        }

        // Add arraylist to linkedlist
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);

        ListIterator<Integer> listIterator = linkedList.listIterator();

        // Iterate through linkedlist and calculate time
        long startTime = System.currentTimeMillis();

        while (listIterator.hasNext())
        {
            listIterator.next();
        }

        long endTime = System.currentTimeMillis();

        // Print time
        System.out.println("Time required to traverse the list using an iterator = "
                + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();

        // Iterate through linkedlist
        for (int i = 0; i < 5000000; i++)
        {
            System.out.println(i);
            linkedList.get(i);
        }

        endTime = System.currentTimeMillis();
        // Print time
        System.out.println("Time required to traverse the list using get(index) = "
                + (endTime - startTime) + " milliseconds");
    }
}
