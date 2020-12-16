/* Name: Syed Obaid Quadri
 * Date: 11/8/20
 */
import java.util.*;

public class Q20_14
{
    public static void main(String[] args)
    {
        // Check number of command-line arguments
        if (args.length != 1)
        {
            System.out.println("Usage: Java Exercise_20_14 \"Expressions\"");
            System.exit(1);
        }

        try
        {
            System.out.println(evaluateExpression(args[0]));
        } catch (Exception ex)
        {
            System.out.println("Wrong expression: " + args[0]);
        }
    }

    /**
     * Evaluate a postfix notation string
     */
    public static int evaluateExpression(
            String string) throws Exception
    {
        // Create stack1 to store operands
        Stack<Integer> stack1 = new Stack<>();

        string = insertBlanks(string);

        // Extract operands and operators
        String[] tokens = string.split(" ");

        // Scan tokens
        for (String token : tokens)
        {
            if (token.length() == 0) // Blank space
            {
                continue; // Back to the while loop to extract the next token
            }
            else if (token.charAt(0) == '+' || token.charAt(0) == '-' ||
                    token.charAt(0) == '/' || token.charAt(0) == '*')
            {
                // Process all operands in the top of the stack
                processAnOperator(stack1, token.charAt(0));
            } else if (Character.isDigit(token.charAt(0)))
            {
                // Push an operand into the stack
                stack1.push(Integer.parseInt(token));
            } else
                throw new Exception("Wrong string: ");
        }

        // Return the result
        return stack1.pop();
    }

    /**
     * Process one operator: Apply an operator
     * to the operands in the stack
     */
    public static void processAnOperator(
            Stack<Integer> stack2, char operator)
    {
        int op1 = stack2.pop();
        int op2 = stack2.pop();

        switch (operator)
        {
            case '+':
                stack2.push(op2 + op1);
                break;
            case '-':
                stack2.push(op2 - op1);
                break;
            case '/':
                stack2.push(op2 / op1);
                break;
            case '*':
                stack2.push(op2 * op1);
        }
    }

    /**
     * Inserts blanks around +, -, /, and *
     */
    public static String insertBlanks(String s)
    {
        String result = "";

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' ||
                    s.charAt(i) == '/' || s.charAt(i) == '*')
                result += " " + s.charAt(i) + " ";
            else
                result += s.charAt(i);
        }

        return result;
    }
}
