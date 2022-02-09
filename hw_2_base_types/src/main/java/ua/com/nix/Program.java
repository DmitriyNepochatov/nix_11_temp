package ua.com.nix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class Program
{
    private Program(){}

    public static void run()
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            while (true)
            {
                menu();
                switch (reader.readLine())
                {
                    case "1" -> {
                        System.out.println();
                        SumNumStr.makeSumNumStr();
                    }
                    case "2" -> {
                        System.out.println();
                        CountSortLettersStr.makeCountSortLettersStr();
                    }
                    case "3" -> {
                        System.out.println();
                        TimeLessonOver.makeTimeLessonOver();
                    }
                    case "0" -> {
                        System.out.println("\nClose program...");
                        return;
                    }
                    default -> System.out.println("\nWrong input");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void menu()
    {
        System.out.println();
        System.out.println("1. Find the sum of all numbers in a string");
        System.out.println("2. Find the number of characters in a string and sort them");
        System.out.println("3. Find when the specified lesson ends");
        System.out.println("0. Exit");
        System.out.print(">> ");
    }
}
