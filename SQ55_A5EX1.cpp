/*
Syed Obaid Quadri #55
This program will ask the user for an employee number and record their gross pay, federal,
state tax and fica. It will continue to ask until the user exits the program and then it
will print the total gross pay, fed and state tax, and fica total for all employees.
*/

#include <iostream>
#include <iomanip>
using namespace std;

// Function prototypes

void getEmployeeData(int employNum, double& grossPay, double& fedTax, double& stateTax, double& fica);
void validAmountInput(int num, double &pay, double &Ftax, double &Stax, double &fica);
int validEmployee();
void displayFunction(double pay, double Ftax, double Stax, double fica);

/*
Main function.
The function will call all functions and exit the program when the user enters 0
for the employee number where it will then print the total of the 4 variables.
*/

int main()
{
    cout << fixed << showpoint << setprecision(2);

    double pay_gross, tax_fed, tax_state, fica;
    double total_pay_gross = 0, total_tax_fed = 0, total_tax_state = 0, total_fica = 0;
    int employee = 0;

    do
    {
        employee = validEmployee();

        if (employee == 0)
        {
            displayFunction(total_pay_gross, total_tax_fed, total_tax_state, total_fica);
        }
        else
        {
            getEmployeeData(employee, pay_gross, tax_fed, tax_state, fica);

            total_pay_gross += pay_gross;
            total_tax_fed += tax_fed;
            total_tax_state += tax_state;
            total_fica += fica;
        }
    }
    while (employee != 0);
}

/*
This function will get the employees gross pay, federal tax, state tax, and fica holdings.
It will prompt the user for each of the variables and check if it is greater than 0. If all
are valid it will check if gross pay is greater than fedtax + statetax + fica. If not it will
loop back and restart.
*/

void getEmployeeData(int employNum, double& grossPay, double& fedTax, double& stateTax, double& fica)
{
    grossPay = 0, fedTax = 0, stateTax = 0;
    fica = 0;

    do
    {
        do
        {
            cout << "Enter employee #" << employNum << "'s gross pay:" << endl;
            cin >> grossPay;

            if (grossPay < 0)
            {
                cout << "Error, gross pay may not be less than zero." << endl;
            }
        }
        while (grossPay < 0);

        do
        {
            cout << "Enter employee #" << employNum << "'s federal withholding:" << endl;
            cin >> fedTax;

            if (fedTax < 0)
                cout << "Error, federal withholding may not be less than zero." << endl;
        }
        while (fedTax < 0);

        do
        {
            cout << "Enter employee #" << employNum << "'s state withholding:" << endl;
            cin >> stateTax;

            if (stateTax < 0)
                cout << "Error, state withholding may not be less than zero." << endl;
        }
        while (stateTax < 0);

        do
        {
            cout << "Enter employee #" << employNum << "'s FICA withholding:" << endl;
            cin >> fica;

            if (fica < 0)
                cout << "Error, FICA withholding may not be less than zero." << endl;
        }
        while (fica < 0);

        if (fedTax + stateTax + fica > grossPay)
        {
            cout << "Error: Withholdings cannot exceed gross pay." << endl;
        }
    }
    while (fedTax + stateTax + fica > grossPay);
}

/*
This function has no arguments but returns an integer. It will prompt the user for
an employee number. If the number is valid (0 or greater) then it will return it. If
not then it will loop back and ask again.
*/

int validEmployee()
{
    int num, counter = 0;

    if (counter == 0)
    {
        counter++;

        cout << "Enter the first employee's employee number (Enter 0 to quit): " << endl;
    }
    else
    {
        cout << "Enter the next employee's employee number (Enter 0 to quit): " << endl;
    }
    cin >> num;

    while (num < 0)
    {
        cout << "Error, the employee number may not be less than zero." << endl;
        cout << "Re-enter employee Number (Enter 0 to quit):" << endl;
        cin >> num;

        if (num == 0)
            break;
    }

    return num;
}

/*
This function is void. It will display the total of the gross pay, fedtax, statetax,
and fica. It has width 10 for the variables.
*/

void displayFunction(double pay, double Ftax, double Stax, double fica)
{
    cout << right << setw(20) << "Total Gross Pay: $" << right << setw(10) << pay << endl;
    cout << right << setw(20) << "Total Federal Tax: $" << right  << setw(10) << Ftax << endl;
    cout << right << setw(20) << "Total State Tax: $"  << right << setw(10) << Stax << endl;
    cout << right << setw(20) << "Total FICA: $"  << right << setw(10) << fica << endl;
    cout << right << setw(20) << "Total Net Pay: $"  << right << setw(10) << pay - Ftax - Stax - fica << endl;
}




