package ua.com.nix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.lang3.*;

public final class SumNumStr
{
    private SumNumStr(){}

    public static void makeSumNumStr()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            int sum = 0;

            while (true)
            {
                System.out.print("Enter some string : ");
                line = reader.readLine();
                if (StringUtils.isBlank(line))
                {
                    System.out.println("incorrect input");
                    continue;
                }

                for (int i = 0; i < line.length(); i++)
                {
                    if (Character.isDigit(line.charAt(i)))
                        sum += Integer.parseInt(String.valueOf(line.charAt(i)));
                }

                System.out.println("sum = " + sum);
                System.out.print("Continue? y/n : ");
                line = reader.readLine();
                if (line.charAt(0) == 'y')
                    sum = 0;
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
}