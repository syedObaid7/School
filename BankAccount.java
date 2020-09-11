
import javax.swing.JOptionPane;

public class BankAccount
{

    private double balance;
    private String customerName;
    private int accountNumber;

    public BankAccount()
    {

    }

    public BankAccount(String customerName, int accountNumber)
    {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
    }

    public void openAccount()
    {
        String input;

        input = JOptionPane.showInputDialog("Enter account holders name.");
        this.customerName = input;

        input = JOptionPane.showInputDialog("Enter account number.");
        this.accountNumber = Integer.parseInt(input);

        System.out.println("Enter the amount you would like to deposit");
        input = JOptionPane.showInputDialog("Enter the amount you would like to deposit");
        this.balance = Double.parseDouble(input);
    }

    public void deposit(double deposit)
    {
        if (deposit > 0)
        {
            this.balance += deposit;

            JOptionPane.showMessageDialog(null, "You have successfully deposited $" + deposit + ".\n"
                    + "You now have $" + this.balance + " in your account");

        } else
        {
            JOptionPane.showMessageDialog(null, "Cannot deposit $" + deposit
                    + ". Deposit ammount needs to be greater than $0.");
        }
    }

    public void withdraw(double withdraw)
    {
        if (this.balance >= withdraw)
        {
            this.balance -= withdraw;

            JOptionPane.showMessageDialog(null, "You have successfully withdrawn $" + withdraw
                    + ".\n" + "You now have $" + this.balance + " in your account");

        } else
        {
            JOptionPane.showMessageDialog(null, "Cannot withdraw $" + withdraw + ".\n"
                    + "Not enough balance. Only $" + this.balance + " available.");
        }

    }

    public void menu()
    {
        String input;
        int option;
        boolean again;

        JOptionPane.showMessageDialog(null, "Welcome " + customerName
                + "\nAccount number: " + accountNumber);

        do
        {
            do
            {
                input = JOptionPane.showInputDialog(null, "\nWhat would you like to do?"
                        + "\n1. Create a new account"
                        + "\n2. Check Balance"
                        + "\n3. Deposit"
                        + "\n4. Withdraw"
                        + "\n5. Exit"
                        + "\nEnter an option.");

                option = Integer.parseInt(input);

                if (option < 1 || option > 5)
                {
                    JOptionPane.showMessageDialog(null, "Invalid option. Try again");
                }

            } while (option < 1 || option > 5);

            switch (option)
            {
                case 1:
                    JOptionPane.showMessageDialog(null, "Welcome new customer");
                    openAccount();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Your current balance is: $" + this.balance);
                    break;
                case 3:
                    input = JOptionPane.showInputDialog("Enter the amount you would like to deposit");
                    double num1 = Double.parseDouble(input);
                    deposit(num1);
                    break;
                case 4:
                    input = JOptionPane.showInputDialog("Enter the amount you would like to withdraw");
                    double num2 = Double.parseDouble(input);
                    withdraw(num2);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Thank you. Have a good day!");
                    break;
            }

            again = somethingElse();

        } while (again == true);
    }

    private boolean somethingElse()
    {
        String input;
        boolean again = false;

        input = JOptionPane.showInputDialog("Would you like to do something else? (Y or N)");

        char c = input.charAt(0);

        switch (c)
        {
            case 'Y':
            case 'y':
                again = true;
                break;
            case 'N':
            case 'n':
                again = false;
                JOptionPane.showMessageDialog(null, "Thank you!");
                break;
        }

        return again;
    }
}
