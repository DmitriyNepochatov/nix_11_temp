package ua.com.nix.uniquenumbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.*;

public final class AmountOfUniqueNumbers
{
    private AmountOfUniqueNumbers() {}

    public static void findAmountOfUniqueNumbers()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true)
            {
                Set<Integer> set = new HashSet<>();

                System.out.print("Enter some string >> ");
                String line = reader.readLine();
                if (StringUtils.isBlank(line))
                {
                    System.out.println("incorrect input");
                    continue;
                }

                line = line.replaceAll("[^\\d.]", "");
                for (int i = 0; i < line.length(); i++)
                {
                    set.add(Integer.parseInt(String.valueOf(line.charAt(i))));
                }
                System.out.println("Amount of unique numbers: " + set.size());

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
