 #include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
using namespace std;

bool readFunction(ifstream &file, long long int &sales, unsigned int &num);
void displayFunction(ofstream &file, long long int sales, unsigned int num);

int main()
{
    string fileName;
    unsigned int storeNum;
    long long int storeVal;
    bool valid;


    cout << "Enter input file name" << endl;
    getline(cin, fileName);

    ifstream inputFile;
    inputFile.open(fileName);

    if (inputFile.fail())
    {
        cout << "File \"" << fileName << "\" could not be opened" << endl;
        exit(EXIT_FAILURE);
    }

    ofstream outputFile;
    outputFile.open("saleschart.txt");

    if (!outputFile)
    {
        cout << "File ""\"saleschart.txt""\" could not be opened " << endl;
        outputFile.close();
    }
    else
    {
        outputFile << "SALES BAR CHART\n(Each * equals 5,000 dollars)" << endl;

        while (inputFile >> storeNum >> storeVal)
        {
            valid = readFunction(inputFile, storeVal, storeNum);

            if (valid)
            {
                displayFunction(outputFile, storeVal, storeNum);
            }
        }
    }

    inputFile.close();
    outputFile.close();
}

bool readFunction(ifstream &file, long long int &sales, unsigned int &num)
{
    bool valid = true;

    if (num < 1 || num > 99)
    {
        cout << "The store number " << num << " is not valid" << endl;
        valid = false;

    }
    else if (sales < 0)
    {
        cout << "The sales value for store " << num << " is negative" << endl;
        valid = false;
    }

    return valid;
}

void displayFunction(ofstream &file, long long int sales, unsigned int num)
{
    int i, j;

    i = sales / 5000;
    j = i;

    file << "Store " << setw(2) << num << ": ";

    for (i = 0; i < j; i++)
    {
        file << '*';
    }

    file << endl;

}
