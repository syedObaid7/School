/* Name: Syed Obaid Quadri
 * Date: 10/30/2020
 * Description: This program performs binary search
 */

// Imports

import java.util.Arrays;

public class Q19_7
{
    // Main
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

        // Sort array for binary search
        Arrays.sort(intArray);
        Arrays.sort(doubleArray);
        Arrays.sort(charArray);
        Arrays.sort(stringArray);

        // Print sorted array to compare to original
        System.out.println("Sorted intArray = " + Arrays.toString(intArray));
        System.out.println("Sorted doubleArray = " + Arrays.toString(doubleArray));
        System.out.println("Sorted charArray = " + Arrays.toString(charArray));
        System.out.println("Sorted stringArray = " + Arrays.toString(stringArray) + '\n');

        // Implementation of generic binary search
        System.out.println("Found at index " + binarySearch(intArray, 3));
        System.out.println("Found at index " + binarySearch(doubleArray, 1.3));
        System.out.println("Found at index " + binarySearch(charArray, 'M'));
        System.out.println("Found at index " + binarySearch(stringArray, "Tom"));
    }

    // Generic binary Search method
    public static <E extends Comparable<E>>
    int binarySearch(E[] list, E key)
    {
        int low = 0;
        int high = list.length - 1;

        while (high >= low)
        {
            int mid = (low + high) / 2;
            if (key.compareTo(list[mid]) < 0)
                high = mid - 1;
            else if (key.compareTo(list[mid]) == 0)
                return mid;
            else
                low = mid + 1;
        }

        return -low - 1; // Now high < low, key not found
    }
}



