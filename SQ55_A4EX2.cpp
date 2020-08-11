/* Gradebook #55
* The program will calculate area and circumference of a circle from coordinates that it will read in.
*/
#include <iostream>
#include <cmath>
using namespace std;

// Function prototypes

void askCoordinates(double &, double &, double &, double &);
double findEquation(double &, double &, double &, double &);
double findArea(double);
double findCircum(double);


int main()
{
    double x_center, y_center, x_point, y_point, radius, area, circum;

    // Call function to ask for coordinates

    askCoordinates(x_center, y_center, x_point, y_point);

    // Call function to find radius

    radius = findEquation(x_center, y_center, x_point, y_point);

    // Print equation

    cout << "A circle centered at (" << x_center << ", " << y_center << ") passing through a point ("
        << x_point << ", " << y_point << ") has the equation: " << endl;

    if (x_center >= 0)
    {
        cout << "(x - " << x_center;
    } else
    {
        cout << "(x + " << x_center * -1;
    }

    if (y_center >= 0)
    {
        cout << ")^2 + (y - " << y_center << ")^2 = " << pow(radius, 2) << endl;
    } else
    {
        cout << ")^2 + (y + " << y_center * -1 << ")^2 = " << pow(radius, 2) << endl;
    }

    // Call function to find area

    area = findArea(radius);

    cout << "The circle has an area of " << area << " square units." << endl;

    // Call funtion to find circumference

    circum = findCircum(radius);

    cout << "The circle has a circumference of " << circum << " units." << endl;


    return 0;
}

// Function will ask user to enter coordinates

void askCoordinates(double &xC, double &yC, double &xP, double &yP)
{

    cout << "Enter the X and Y coordinate of the center of the circle" << endl;
    cin >> xC;
    cin.ignore();
    cin >> yC;

    cout << "Enter the X and Y coordinates of the point on the circle" << endl;
    cin >> xP;
    cin.ignore();
    cin >> yP;
}

// Funtion will do math to find radius

double findEquation(double &xC, double &yC, double &xP, double &yP)
{
    double temp1, temp2, rad;

    temp1 = xC - xP;
    temp1 = pow(temp1, 2);

    temp2 = yC - yP;
    temp2 = pow(temp2, 2);

    rad = temp1 + temp2;

    return pow(rad, 0.5);
}

// Function will do math to calculate area

double findArea(double radius)
{
    double Area = acos(-1) * pow(radius, 2);

    return Area;
}

// Function will do math to calculate circumference

double findCircum(double radius)
{
    double Circum = 2 * acos(-1) * radius;

    return Circum;
}










