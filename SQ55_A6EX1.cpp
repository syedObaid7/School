/*  Name: Syed Quadri
    Gradebook number: 55
    Date: 4/27

    Purpose of program: This program takes in an input asking the user for the name of an output file,
    and the offset by which to encrypt the data. It performs input validation on this data to make sure
    it is between 2 and 95. It then asks the user for a string (or multiple strings) and encrypts it by increasing each
    characters ASCII value by the offset provided by the user. It then writes the encrypted message to the output file.

*/

#include <iostream>
#include <string>
#include <fstream>
using namespace std;

char encode(char char1, int num1);

int main()
{
    // define variables

    string fileName, codeStr;
    int offset;
    char placeHold;

    // get the name of the output file

    cout << "Enter the name of output file." << endl;
    cin >> fileName;

    // define and open the output file

    ofstream outputFile;
    outputFile.open(fileName);

    // this do while loop helps perform input validation inputted by the user.
    // if the number is less than 1 or greater than 94, it will display an error message and ask the user again.

    do
    {
        cout << "Enter the code offset:" << endl;
        cin >> offset;
        cin.ignore();

        if (offset < 1 || offset > 94)
        {
            cout << "Offset value not in range" << endl;
        }
    }
    while (offset < 1 || offset > 94);

    cout << "Enter your message terminating it with an empty line." << endl;

    // get the line entered by the string, and keep reading lines unless it is an empty line.

    while (getline(cin, codeStr) && codeStr.length() > 0)
    {
        // this for loop will pass each character in the line to the encode function
        // where it will convert it to the encoded character and return it.
        // It will then print this character to the output file

        for (int i = 0; i < codeStr.length(); i++)
        {
            placeHold = codeStr.at(i);

            // write encoded character to the output file

            outputFile << encode(placeHold, offset);
        }


        // newline after each line

        outputFile << endl;
    }

    // close the file

    outputFile.close();
}

/* This function adds the number inputted by the user to the ASCII value of the character. If the ASCII value
    exceed 126, then it will start again from the first printable ASCII value. It is of char function type.
    Parameters: letter (char) - the character whose ASCII value needs to be modified
                num (int) - the user input by which to increment the ASCII value by

    Returns : newLetter (char)
*/

char encode(char letter, int num)
{
    // increment the ASCII value

    int temp = letter + num;

    // go back to the beginning of ASCII values if value exceeds 126

    if (temp > 126)
    {
        temp -= 95;
    }

    // convert the number to its corresponding character

    char newLetter = static_cast<char>(temp);

    // return the character

    return newLetter;
}

