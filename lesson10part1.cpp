#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>

using namespace std;

int readFunction1(ifstream &file1, char array1[]);
int readFunction2(ifstream &file2, char array2[]);
void displayFunction(char array1[], char array2[], int A);

int main()
{
    char answers[30];
    char correctAnswers[30];
    string fileName1, fileName2;
    int num1, num2;
    ifstream inputFile1, inputFile2;

    cout << "Enter student answers file name" << endl;
    cin >> fileName1;

    inputFile1.open(fileName1);

    if (!inputFile1)
    {
        cout << "File \"" << fileName1 << "\" could not be opened" << endl;
        (EXIT_FAILURE);
    }
    else
    {

        cout << "Enter correct answer file name" << endl;
        cin >> fileName2;

        inputFile2.open(fileName2);

        if (!inputFile2)
        {
            cout << "File \"" << fileName2 << "\" could not be opened" << endl;
            (EXIT_FAILURE);
        }
        else
        {
            num1 = readFunction1(inputFile1, answers);
            num2 = readFunction2(inputFile2, correctAnswers);

            if (num1 != num2)
            {
                cout << "The student answers file has " << num1 << " entries and the correct answers file has "
                     << num2 << " entries" << endl;
                cout << "Grading cannot be done if they are not the same" << endl;
            }
            else if (num1 == 0 && num2 == 0)
            {
                cout << "The number of student answers and correct answers are both 0" << endl;
                cout << "No grade can be calculated" << endl;
            }
            else
            {
                displayFunction(answers, correctAnswers, num1);
            }
        }

        inputFile1.close();

    }
}


int readFunction1(ifstream &file1, char array1[])
{
    int count = 0;
    int i = 0;

    while (file1 >> array1[i])
    {
        i++;
        count++;
    }

    if (count > 30)
    {
        return 30;
    }
    else if (count <= 30)
    {
        return count;
    }
    else
    {
        return -1;
    }
}

int readFunction2(ifstream &file2, char array2[])
{
    int count = 0;
    int i = 0;

    while (file2 >> array2[i])
    {
        i++;
        count++;
    }

    if (count > 30)
    {
        return 30;
    }
    else if (count <= 30)
    {
        return count;
    }
    else
    {
        return -1;
    }

}

void displayFunction(char array1[], char array2[], int A)
{
    int i, count = 0;
    double grade;

    for (i = 0; i < A; i++)
    {
        if(array1[i] != array2[i])
        {
            cout << "Question " << i + 1 << " has incorrect answer '" << array1[i]
                 << "', the correct answer is '" << array2[i] << "'" << endl;

            count++;
        }
    }
    cout << count << " questions were missed out of " << i << endl;

    cout << fixed << showpoint << setprecision(1);

    grade = 100 - ((static_cast<double>(count) / static_cast<double>(i)) * 100);

    cout << "The student grade is " << grade << "%" << endl;

    if (grade >= 70)
    {
        cout << "The student passed" << endl;
    }
    else
    {
        cout << "The student failed" << endl;
    }
}







