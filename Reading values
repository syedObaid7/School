#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>

using namespace std;

void openInputFile(ifstream &input, string &file);
void failTest(ifstream &input, string file);
void openOutputFile(ofstream &output);

int main()
{
    cout << fixed << showpoint << setprecision(4);

    string fileName;
    ifstream inputFile;
    ofstream outputFile;
    double num;
    int val=0, inval=0;
    double total=0, average=0;

    openInputFile(inputFile, fileName);
    failTest(inputFile, fileName);
    openOutputFile(outputFile);

    while (inputFile >> num)
    {
        if (num < 0 || num > 105)
        {
            outputFile << fixed << setprecision(5) << num << endl;
            inval++;
        } else
        {
            val++;
            total += num;
        }
    }

    average = total / val;


    cout << "Reading from file \"" << fileName << "\"" << endl;
    cout << "Total values: " << val + inval << endl;
    cout << "Invalid values: " << inval << endl;
    cout << "Valid values: " << val << endl;

    if (val == 0)
        cout << "An average cannot be calculated" << endl;
    else
        cout << "Average of valid values: " << total / val << endl;

    inputFile.close();
    outputFile.close();
}

void openInputFile(ifstream &input, string &file)
{
    cout << "Enter input file name" << endl;
    cin >> file;

    input.open(file);
}

void failTest(ifstream &input, string file)
{
    if (input.fail())
    {
        cout << "File \"" << file << "\" could not be opened" << endl;
        exit(EXIT_FAILURE);
    }
}

void openOutputFile(ofstream &output)
{
    output.open("invalid-values.txt");
}

