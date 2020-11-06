/* Name: Syed Obaid Quadri
 * Date: 10/16/20
 * Description: This program will invoke the toString methods of each class
 */

import java.util.GregorianCalendar;

public class Q11_2
{
    public static void main(String[] args)
    {
        Person person = new Person("Adam", "123 Plano",
                "7057455833", "adam@gmail.com");

        Student student = new Student("Beyonce", "123 Frisco", "6744634044",
                "beyonce@hotmail.com", Student.JUNIOR);

        Employee employee = new Employee("Charlie", "123 Allen", "1456621414",
                "charlie@yahoo.com", "708", 100000);

        Faculty faculty = new Faculty("Denise", "123 Dallas", "7186196938",
                "denise@aol.com", "12", 300000, "1pm to 3pm", "Admiral");

        Staff staff = new Staff("Einstein", "112 Mercer Street", "7714458807",
                "albert@einstein.com", "12", 5000000, "Researcher");

        // Call toString methods
        System.out.println(person.toString() + '\n');

        System.out.println(student.toString() + '\n');

        System.out.println(employee.toString() + '\n');

        System.out.println(faculty.toString() + '\n');

        System.out.println(staff.toString() + '\n');
    }
}

/*
 ******************************************
 *                Person                  *
 *----------------------------------------*
 * -name: String                          *
 * -address: String                       *
 * -phone: String                         *
 * -email: String                         *
 *----------------------------------------*
 * +Person(name: String, address: String, *
 *  phone: String, email: String)         *
 * +getName(): String                     *
 * +getAddress(): String                  *
 * +getPhone(): String                    *
 * +getEmail(): String                    *
 * +toString(): String                    *
 ******************************************
 */

class Person
{
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public Person(String name, String address, String phoneNumber, String email)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String toString()
    {
        return "Name = '" + name + '\'' +
                "\nAddress = '" + address + '\'' +
                "\nPhoneNumber = '" + phoneNumber + '\'' +
                "\nEmail = '" + email + '\'';
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getEmail()
    {
        return email;
    }
}

/*
 **************************************************
 *                   Student                      *
 *------------------------------------------------*
 * -status: String                                *
 *------------------------------------------------*
 * +Student(name: String, address: String,        *
 *  phoneNumber: String, email: String,           *
 *  status: int)                                  *
 * +getStatus(): String                           *
 * +toString(): String                            *
 ************************************************
 */

class Student extends Person
{
    public static final int FRESHMAN = 1;
    public static final int SOPHOMORE = 2;
    public static final int JUNIOR = 3;
    public static final int SENIOR = 4;
    private int status;

    public Student(String name, String address, String phoneNumber, String email, int status)
    {
        super(name, address, phoneNumber, email);
        this.status = status;
    }

    public String getStatus()
    {
        switch (status)
        {
            case 1:
                return "Freshman";
            case 2:
                return "Sophomore";
            case 3:
                return "Junior";
            case 4:
                return "Senior";
        }
        return "Invalid status";
    }

    public String toString()
    {
        return super.toString() + "\nStatus = " + getStatus();
    }
}

/*
 ********************************************************************
 *                        Employee                                  *
 *------------------------------------------------------------------*
 * -office: String                                                  *
 * -salary: double                                                  *
 * -dateHired: myDate                                               *
 *------------------------------------------------------------------*
 * +Employee(name: String, address: String, phoneNumber: String,    *
 *  email: String, office: String, salary: double,                  *
 *  dateHired: myDate);                                             *
 * +getOffice(): String                                             *
 * +getSalary(): double                                             *
 * +getDateHired(): String                                          *
 * +toString(): String                                              *
 ********************************************************************
 */

class Employee extends Person
{
    private String office;
    private double salary;
    private myDate dateHired;

    public Employee(String name, String address, String phoneNumber, String email, String office, double salary)
    {
        super(name, address, phoneNumber, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = new myDate();
    }

    public String getOffice()
    {
        return office;
    }

    public double getSalary()
    {
        return salary;
    }

    public String getDateHired()
    {
        return dateHired.getMonth() + "/" + dateHired.getDay()
                + "/" + dateHired.getYear();
    }

    public String toString()
    {
        return super.toString() + "\nOffice = " + office +
                "\nSalary = $" + salary +
                "\nDateHired = " + getDateHired();
    }
}

/*
 ***********************************************************
 *                      Faculty                            *
 *---------------------------------------------------------*
 * -officeHours: String                                    *
 * -rank: String                                           *
 *---------------------------------------------------------*
 * +Faculty(name: String, address: String,                 *
 *  phoneNumber: String, email: String, office: String,    *
 *  salary: double, officeHours: String, rank: String)     *
 * +getOfficeHours(): String                               *
 * +getRank(): String                                      *
 * +toString(): String                                     *
 ***********************************************************
 */

class Faculty extends Employee
{
    private String officeHours;
    private String rank;

    public Faculty(String name, String address, String phoneNumber, String email, String office, double salary, String officeHours, String rank)
    {
        super(name, address, phoneNumber, email, office, salary);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public String getOfficeHours()
    {
        return officeHours;
    }

    public String getRank()
    {
        return rank;
    }

    public String toString()
    {
        return super.toString() + "\nOfficeHours = " + officeHours + "\nRank = " + rank;
    }
}

/*
 ***********************************************************************
 *                                Staff                                *
 *---------------------------------------------------------------------*
 * -title: String                                                      *
 *---------------------------------------------------------------------*
 * +Staff(name: String, address: String, phoneNumber: String,          *
 *  email: String, office: int, salary: double, title: String)         *
 * +getTitle(): String                                                 *
 * +toString(): String                                                 *
 ***********************************************************************
 */

class Staff extends Employee
{
    private String title;

    public Staff(String name, String address, String phoneNumber, String email, String office, double salary, String title)
    {
        super(name, address, phoneNumber, email, office, salary);
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public String toString()
    {
        return super.toString() + "\nTitle = " + title;
    }
}

/*
 *********************************************
 *                MyDate                    *
 *------------------------------------------*
 * -month: int                              *
 * -day: int                                *
 * -year: int                               *
 *------------------------------------------*
 * +MyDate()                                *
 * +MyDate(timeElapsed: long)               *
 * +getYear(): int                          *
 * +getMonth(): int                         *
 * +getDay(): int                           *
 ********************************************
 */

class myDate
{

    private int month;
    private int day;
    private int year;

    public myDate()
    {
        GregorianCalendar calendar = new GregorianCalendar();

        this.month = calendar.get(GregorianCalendar.MONTH);
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        this.year = calendar.get(GregorianCalendar.YEAR);
    }

    myDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public myDate(long timeElapsed)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(timeElapsed);

        this.month = calendar.get(GregorianCalendar.MONTH);
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        this.year = calendar.get(GregorianCalendar.YEAR);
    }

    public int getMonth()
    {
        return month + 1;
    }

    public int getDay()
    {
        return day;
    }

    public int getYear()
    {
        return year;
    }
}