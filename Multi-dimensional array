#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>

using namespace std;

const int MAX_COLUMNS = 5;

int readFile(double values[][MAX_COLUMNS], int maxRows, string inputFileName);
double average(double values[][MAX_COLUMNS], int numberRows);
double columnAverage(double values[][MAX_COLUMNS], int column, int numberRows);
double smallestValue(double values[][MAX_COLUMNS], int rows);

int main()
{
    const int MAX_ROWS = 30;
    string fileName;
    double grades[MAX_ROWS][MAX_COLUMNS];
    int value;

    cout << fixed << setprecision(2);
    cout << "Enter input file name" << endl;
    getline(cin, fileName);

    int numberRows = readFile(grades, MAX_ROWS, fileName);
    if(numberRows == 0)
    {
        cout << "The input file \"" << fileName << "\" did not contain any data" << endl;
        value = 0;
    }

    else if(numberRows == -1)
    {
        cout<< "File \"" << fileName << "\"  could not be opened" << endl;
        value = 0;
    }
    else
        {
        cout << "Processing " << numberRows << " rows, and " << MAX_COLUMNS << " columns" << endl;

        average(grades,numberRows);

        for(int i = 0; i < MAX_COLUMNS; i++)
        {
            double answer = columnAverage(grades, i, numberRows);
            cout << "Average for column " << i << " is " << answer <<endl;
        }

        for(int j = 0; j < numberRows; j++)
        {
            double smallest = smallestValue(grades,j);
            cout << "Smallest value for row " << j << " is " << smallest << endl;
        }
    }
    return value;

}

int readFile(double values[][MAX_COLUMNS], int maxRows, string fileName)
{
    ifstream inputFile;
    inputFile.open(fileName.c_str());
    int value;

    if(!inputFile)
    {
        value = -1;
    }

    else
    {
        int row = 0, col = 0;

        while(row < maxRows && inputFile >> values[row][col])
        {
            col++;

            if(col >= MAX_COLUMNS)
            {
                col = 0;
                row++;
            }
        }

        inputFile.close();
        value = row;
    }
    return value;
}

double average(double values[][MAX_COLUMNS], int numberRows)
{
    double total = 0;
    for(int i = 0; i < numberRows; i++)
    {
        for(int j = 0; j < MAX_COLUMNS; j++)
        {
            total += values[i][j];
        }
    }
    double average = total / static_cast<double>(MAX_COLUMNS * numberRows);

    cout << "Average for all values is " << average << endl;

    return average;

}

double columnAverage(double values[][MAX_COLUMNS], int column, int numRows)
{
    double total = 0;
    for(int i = 0; i < numRows; i++)
    {
        total += values[i][column];
    }
    double columnAvg = (total / numRows);

    return columnAvg;

}

double smallestValue(double values[][MAX_COLUMNS], int rows)
{
    double smallestNum = values[rows][0];
    for(int i = 0; i < MAX_COLUMNS; i++)
    {
        if(values[rows][i] < smallestNum)
        {
            smallestNum = values[rows][i];
        }

    }
    return smallestNum;
}
