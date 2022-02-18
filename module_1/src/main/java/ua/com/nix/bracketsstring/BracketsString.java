package ua.com.nix.bracketsstring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public final class BracketsString
{
    private BracketsString() {}

    public static void checkBracketsString()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true)
            {
                System.out.print("Enter some string >> ");
                String line = reader.readLine();

                if (checkString(line))
                {
                    System.out.println("String is valid");
                }
                else
                {
                    System.out.println("String is invalid");
                }

                System.out.print("Continue? y/n : ");
                line = reader.readLine();
                if (line.charAt(0) == 'y')
                    continue;
                else if (line.charAt(0) == 'n')
                    break;
                else
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static boolean checkString(String str)
    {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++)
        {
            char symbol = str.charAt(i);

            if (symbol == '[' || symbol == '(' || symbol == '{')
            {
                stack.push(symbol);
            }
            else if (symbol == ']')
            {
                if (stack.isEmpty() || stack.pop() != '[')
                {
                    return false;
                }
            }
            else if (symbol == ')')
            {
                if (stack.isEmpty() || stack.pop() != '(')
                {
                    return false;
                }
            }
            else if (symbol == '}')
            {
                if (stack.isEmpty() || stack.pop() != '{')
                {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
