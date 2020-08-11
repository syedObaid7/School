/* Gradebook #55
* This program will ask for the number of shares, price of the shares, sale of the sales, plus commission
* and calculate whether the transaction is a profit or loss
*/

#include <iostream>
#include <iomanip>
using namespace std;

int shares;
double purchase_price, purchase_commission, sale_commission, sale_price, result;

int AskForShares();
double PurchasePrice();
double PurchaseCommission();
double SalePrice();
double SaleCommission();
double ProftLossCalc();

int main()
{
    // Set precision for numbers

    cout << fixed << setprecision(2);

    // Call function

    AskForShares();

    // Validate function input

    if (shares > 0)
    {
        // Call functions

        PurchasePrice();
        PurchaseCommission();
        SalePrice();
        SaleCommission();
        ProftLossCalc();

    } else
    {
        cout << "Error, the number of shares must be greater than zero." << endl;
    }

    return 0;
}

// Function will ask the user to enter the number of stock and return it

int AskForShares()
{
    cout << "Enter the number of shares of the stock:" << endl;
    cin >> shares;

    return shares;
}

// Function will ask the user to enter the purchase price and return it

double PurchasePrice()
{
    cout << "Enter the purchase price for the stock:" << endl;
    cin >> purchase_price;

    return purchase_price;
}

// Function will ask the user to enter the purchase commission and return it

double PurchaseCommission()
{
    cout << "Enter the commission on the purchase of the stock:" << endl;
    cin >> purchase_commission;

    return purchase_commission;
}

// Function will ask the user to enter the sale price of the stock and return it

double SalePrice()
{
    cout << "Enter the sales price of the stock:" << endl;
    cin >> sale_price;
}

// Function will ask the user to enter the sale commission of the stock and return it

double SaleCommission()
{
    cout << "Enter the commission on the sale of the stock:" << endl;
    cin >> sale_commission;

    return sale_commission;
}

/* Function will take it all previous values that were returned, apply it to the equation and print whether
    it was a profit, loss, or broke even */

double ProftLossCalc()
{
    result = ((shares * sale_price) - sale_commission) - ((shares * purchase_price) + purchase_commission);

    if (result == 0)
    {
        cout << "You broke even on the stock sale." << endl;
    } else if (result > 0)
    {
        cout << "The stock was sold for a profit of $" << result << endl;
    } else
    {
        cout << "The stock was sold for a loss of $" << result << endl;
    }
}






















