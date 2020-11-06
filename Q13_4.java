/* Name: Syed Obaid Quadri
 * Date: 10/24/20
 * Description: This program will take a month and year as input and print out the days of the month
 */

// Imports

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Q13_4
{
    // Main
    public static void main(String[] args)
    {
        // Create calendar object
        Calendar calendar = new GregorianCalendar(Integer.parseInt(args[1]),
                Integer.parseInt(args[0]) - 1, 1);

        // Call method
        printHeader(calendar);

        // Call method and place return value into variable
        int firstDay = getFirstDay(calendar);

        // Add spaces before the first day
        for (int i = 1; i < firstDay; i++)
        {
            System.out.printf("%4s", " ");
        }

        // Call method and return value into variable
        int daysInMonth = daysInMonth(calendar);

        int count = firstDay;

        // Iterate through the days and print them, new line when 7 days have passed
        for (int i = 1; i <= daysInMonth; i++)
        {
            System.out.printf("%4d", i);

            if (count % 7 == 0)
            {
                System.out.println();
            }
            count++;
        }
    }

    // This method prints the month heading
    public static void printHeader(Calendar calendar)
    {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        System.out.printf("%8s", " ");

        System.out.println(months[calendar.get(Calendar.MONTH)]
                + ", " + calendar.get(Calendar.YEAR));
        
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    // This method returns the first day of the month
    public static int getFirstDay(Calendar calendar)
    {
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    // This method returns a boolean value depending on whether the year is a leap year
    public static boolean isLeapYear(Calendar calendar)
    {
        boolean leapYear;

        if (calendar.get(Calendar.YEAR) % 4 == 0)
        {
            if (calendar.get(Calendar.YEAR) % 100 == 0)
            {
                if (calendar.get(Calendar.YEAR) % 400 == 0)
                {
                    leapYear = true;
                } else
                {
                    leapYear = false;
                }
            } else {
                leapYear = true;
            }
        }
        else
        {
            leapYear = false;
        }

        return leapYear;
    }

    // This method returns the number of days in that month
    public static int daysInMonth(Calendar calendar)
    {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(calendar) && calendar.get(Calendar.MONTH) == 1)
        {
            daysInMonth[1] = 29;
        }

        return daysInMonth[calendar.get(Calendar.MONTH)];
    }
}
