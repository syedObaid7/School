/* Name: Syed Obaid Quadri
 * Date: 10/24/2020
 * Description: This program will implement the comparable interface and compare the
 *              area of 2 objects
 */

public class Q13_10
{
    // Main
    public static void main(String[] args)
    {
        // Create 3 rectangle objects
        Rectangle r1 = new Rectangle(5, 10, "Yellow", true);
        Rectangle r2 = new Rectangle(10, 5, "Pink", true);
        Rectangle r3 = new Rectangle(3, 15, "Black", false);

        // Compare r1 and r2
        System.out.print("Area of Rectangle 1 (" + r1.getArea());

        if (r1.isEqual(r2))
        {
            System.out.print(") is equal to area of ");
        } else
        {
            System.out.print("not equal to area of ");
        }

        System.out.println("Rectangle 2 (" + r2.getArea() + ")");

        // Compare r1 and r3
        System.out.print("Area of Rectangle 1 (" + r1.getArea());

        if (r1.isEqual(r3))
        {
            System.out.print(") is equal to area of ");
        } else
        {
            System.out.print(") is not equal to area of ");
        }

        System.out.println("Rectangle 3 (" + r3.getArea() + ")");
    }
}

abstract class GeometricObject
{
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    /**
     * Construct a default geometric object
     */
    public GeometricObject()
    {
        dateCreated = new java.util.Date();
    }

    /**
     * Construct a geometric object with the specified color
     * 12 * and filled value
     */
    public GeometricObject(String color, boolean filled)
    {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;

    }

    /**
     * Return color
     */
    public String getColor()
    {
        return color;

    }

    /**
     * Set a new color
     */
    public void setColor(String color)
    {
        this.color = color;

    }

    /**
     * Return filled. Since filled is boolean,
     * 30 its getter method is named isFilled
     */
    public boolean isFilled()
    {
        return filled;

    }

    /**
     * Set a new filled
     */
    public void setFilled(boolean filled)
    {
        this.filled = filled;

    }

    /**
     * Get dateCreated
     */
    public java.util.Date getDateCreated()
    {
        return dateCreated;

    }

    /**
     * Return a string representation of this object
     */
    public String toString()
    {
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }

    public abstract boolean isEqual(Object o);
}

class Rectangle extends GeometricObject implements Comparable<Rectangle>
{
    private double width;
    private double height;

    public Rectangle()
    {
    }

    public Rectangle(double width, double height)
    {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled)
    {
        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(filled);
    }

    /**
     * Return width
     */
    public double getWidth()
    {
        return width;
    }

    /**
     * Set a new width
     */
    public void setWidth(double width)
    {
        this.width = width;
    }

    /**
     * Return height
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * Set a new height
     */
    public void setHeight(double height)
    {
        this.height = height;
    }

    /**
     * Return area
     */
    public double getArea()
    {
        return width * height;
    }

    /**
     * Return perimeter
     */
    public double getPerimeter()
    {
        return 2 * (width + height);
    }

    @Override
    public int compareTo(Rectangle o)
    {
        if (this.getArea() == o.getArea())
        {
            return 0;
        } else if (this.getArea() > o.getArea())
        {
            return 1;
        } else
        {
            return -1;
        }
    }

    @Override
    public boolean isEqual(Object o)
    {
        return this.compareTo((Rectangle) o) == 0;
    }
}
