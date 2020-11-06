/* Name: Syed Obaid Quadri
 * Date: 10/30/2020
 * Description: This program performs linear search
 */
public class Q19_4
{

    public static void main(String[] args)
    {
        // Create an Integer array
        Integer[] intArray = {2, 4, 3, 5, 8, 34};

        // Create a Double array
        Double[] doubleArray = {3.4, 1.3, -22.1, 45.7, 0.6};

        // Create a Character array
        Character[] charArray = {'a', 'J', 'r', '$', 'M'};

        // Create a String array
        String[] stringArray = {"Tom", "Susan", "Kim", "Liam", "Albert"};

        // Implementation of generic linear search
        System.out.println("Found at index " + linearSearch(intArray, 3));
        System.out.println("Found at index " + linearSearch(doubleArray, 1.3));
        System.out.println("Found at index " + linearSearch(charArray, 'M'));
        System.out.println("Found at index " + linearSearch(stringArray, "Tom"));
    }

    // Generic linear search method
    public static <E extends Comparable<E>>
    int linearSearch(E[] list, E key)
    {
        // Search loop
        for (int i = 0; i < list.length; i++)
        {
            if (key.compareTo(list[i]) == 0)
            {
                return i;
            }
        }

        return -1;
    }
}
