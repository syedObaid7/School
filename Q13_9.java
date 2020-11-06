/* Name: Syed Obaid Quadri
 * Date: 10/24/2020
 * Description: This program will implement the comparable interface and compare the
 *              radius of 2 objects
 */

public class Q13_9
{
    public static void main(String[] args)
    {
        // Create 3 circle objects
        Circle c1 = new Circle(5, "Purple", true);
        Circle c2 = new Circle(3, "blue", true);
        Circle c3 = new Circle(5, "green", false);

        // Compare c1 and c2
        System.out.print("Radius of Circle 1 (" + c1.getRadius());

        if (c1.isEqual(c2))
        {
            System.out.print(") is equal to the radius of ");
        } else
        {
            System.out.print(") is not equal to the radius of ");
        }
        System.out.println("Circle 2 (" + c2.getRadius() + ")");

        // Compare c1 and c3
        System.out.print("Radius of Circle 1 (" + c1.getRadius());

        if (c1.isEqual(c3))
        {
            System.out.print(") is equal to the radius of ");
        } else
        {
            System.out.print(") is not equal to the radius of ");
        }
        System.out.println("Circle 3 (" + c3.getRadius() + ")");
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

class Circle extends GeometricObject implements Comparable<Circle>
{
    private double radius;

    public Circle()
    {
    }

    public Circle(double radius)
    {
        this.radius = radius;
    }

    public Circle(double radius,
                  String color, boolean filled)
    {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    /**
     * Return radius
     */
    public double getRadius()
    {
        return radius;
    }

    /**
     * Set a new radius
     */
    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    /**
     * Return area
     */
    public double getArea()
    {
        return radius * radius * Math.PI;
    }

    /**
     * Return diameter
     */
    public double getDiameter()
    {
        return 2 * radius;
    }

    /**
     * Return perimeter
     */
    public double getPerimeter()
    {
        return 2 * radius * Math.PI;
    }

    /**
     * Print the circle info
     */
    public void printCircle()
    {
        System.out.println("The circle is created " + getDateCreated() +
                " and the radius is " + radius);
    }

    @Override
    public int compareTo(Circle o)
    {
        if (this.radius == o.radius)
        {
            return 0;
        } else if (this.radius > o.radius)
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
        return this.compareTo((Circle) o) == 0;
    }
}
