package ua.com.nix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

public class TaskTwo
{
    public void taskTwoMethod()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while (true)
            {
                System.out.print("Enter some string : ");
                line = reader.readLine();
                if (StringUtils.isBlank(line))
                {
                    System.out.println("incorrect input");
                    continue;
                }

                String finishedString = "";
                for (int i = 0; i < line.length(); i++)
                {
                    if ((line.charAt(i) >= 'A' && line.charAt(i) <= 'z') || (line.charAt(i) >= 'А' && line.charAt(i) <= 'я'))
                        finishedString += line.charAt(i);
                }

                char[] symbols = new char[33];
                int[] values = new int[33];
                int arrPoint = 0;
                for (int i = 0; i < finishedString.length(); i++)
                {
                    boolean flag = false;
                    char temp = Character.toLowerCase(finishedString.charAt(i));
                    int tempCharQuantity = 0;
                    for (int j = 0; j < symbols.length; j++)
                    {
                        if (temp == symbols[j])
                        {
                            flag = true;
                            break;
                        }
                    }
                    if (flag)
                        continue;
                    else
                    {
                        for (int j = i; j < finishedString.length(); j++)
                        {
                            if (temp == Character.toLowerCase(finishedString.charAt(j)))
                            {
                                tempCharQuantity++;
                            }
                        }
                        symbols[arrPoint] = temp;
                        values[arrPoint] = tempCharQuantity;
                        arrPoint++;
                    }
                }

                int finalValues = 0;
                for (int i = 0; i < values.length; i++)
                {
                    if (values[i] != 0)
                        finalValues++;
                }

                char[] finalSymbols = new char[finalValues];
                int[] finalValue = new int[finalValues];

                for (int i = 0; i < finalValues; i++)
                {
                    finalSymbols[i] = symbols[i];
                    finalValue[i] = values[i];
                }

                for (int i = 0; i < finalSymbols.length; i++)
                {
                    for (int j = i + 1; j < finalSymbols.length; j++)
                    {
                        if (finalSymbols[j] < finalSymbols[i])
                        {
                            char temp = finalSymbols[i];
                            finalSymbols[i] = finalSymbols[j];
                            finalSymbols[j] = temp;

                            int tempV = finalValue[i];
                            finalValue[i] = finalValue[j];
                            finalValue[j] = tempV;
                        }
                    }
                }

                System.out.println("Result is:");
                for (int i = 0; i < finalSymbols.length; i++)
                {
                    System.out.println(i + ". " + finalSymbols[i] + " - " + finalValue[i]);
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
}