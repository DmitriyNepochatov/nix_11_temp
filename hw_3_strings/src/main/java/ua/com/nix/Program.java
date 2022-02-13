package ua.com.nix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static ua.com.nix.ReverseStringUtil.*;

public final class Program
{
    private Program() {}

    public static void runProgram()
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            String str = null;
            String result;
            boolean flag;

            while (true)
            {
                System.out.print("Enter some string >> ");
                str = reader.readLine();
                if (str == null || str.equals(" "))
                {
                    System.out.println("\nEmpty string");
                    continue;
                }

                flag = false;
                while (!flag)
                {
                    result = null;
                    System.out.println("\nInput string is: " + str);
                    menu();
                    switch (reader.readLine())
                    {
                        case "1" -> {
                            System.out.println("\nString before: " + str);
                            System.out.println("String after:  " + simpleReverse(str));
                        }
                        case "2" -> {
                            System.out.println("\nString before: " + str);
                            System.out.println("String after:  " + reverseAllWords(str));
                        }
                        case "3" -> {
                            System.out.print("\nEnter substring >> ");
                            String sub = reader.readLine();
                            result = reverseSubStringSimple(str, sub);
                            if (result != null)
                            {
                                System.out.println("\nString before: " + str);
                                System.out.println("String after:  " + result);
                            }
                            else
                                System.out.println("\nIncorrect input");
                        }
                        case "4" -> {
                            System.out.print("\nEnter substring >> ");
                            String sub = reader.readLine();
                            result = reverseSubStringAllWords(str, sub);
                            if (result != null)
                            {
                                System.out.println("\nString before: " + str);
                                System.out.println("String after:  " + result);
                            }
                            else
                                System.out.println("\nIncorrect input");
                        }
                        case "5" -> {
                            System.out.print("\nEnter first index >> ");
                            int first = Integer.parseInt(reader.readLine());
                            System.out.print("\nEnter second index >> ");
                            int second = Integer.parseInt(reader.readLine());
                            result = reverseForIndexesSimple(str, first, second);
                            if (result != null)
                            {
                                System.out.println("\nString before: " + str);
                                System.out.println("String after:  " + result);
                            }
                            else
                                System.out.println("\nIncorrect input");
                        }
                        case "6" -> {
                            System.out.print("\nEnter first index >> ");
                            int first = Integer.parseInt(reader.readLine());
                            System.out.print("\nEnter second index >> ");
                            int second = Integer.parseInt(reader.readLine());
                            result = reverseForIndexesAllWords(str, first, second);
                            if (result != null)
                            {
                                System.out.println("\nString before: " + str);
                                System.out.println("String after:  " + result);
                            }
                            else
                                System.out.println("\nIncorrect input");
                        }
                        case "7" -> {
                            System.out.print("\nEnter first symbol >> ");
                            char first = reader.readLine().charAt(0);
                            System.out.print("\nEnter second symbol >> ");
                            char second = reader.readLine().charAt(0);
                            result = reverseForSymbolsSimple(str, first, second);
                            if (result != null)
                            {
                                System.out.println("\nString before: " + str);
                                System.out.println("String after:  " + result);
                            }
                            else
                                System.out.println("\nIncorrect input");
                        }
                        case "8" -> {
                            System.out.print("\nEnter first symbol >> ");
                            char first = reader.readLine().charAt(0);
                            System.out.print("\nEnter second symbol >> ");
                            char second = reader.readLine().charAt(0);
                            result = reverseForSymbolsAllWords(str, first, second);
                            if (result != null)
                            {
                                System.out.println("\nString before: " + str);
                                System.out.println("String after:  " + result);
                            }
                            else
                                System.out.println("\nIncorrect input");
                        }
                        case "9" -> {
                            System.out.print("\nEnter first substring >> ");
                            String first = reader.readLine();
                            System.out.print("\nEnter second substring >> ");
                            String second = reader.readLine();
                            result = reverseForStringSimple(str, first, second);
                            if (result != null)
                            {
                                System.out.println("\nString before: " + str);
                                System.out.println("String after:  " + result);
                            }
                            else
                                System.out.println("\nIncorrect input");
                        }
                        case "10" -> {
                            System.out.print("\nEnter first substring >> ");
                            String first = reader.readLine();
                            System.out.print("\nEnter second substring >> ");
                            String second = reader.readLine();
                            result = reverseForStringAllWords(str, first, second);
                            if (result != null)
                            {
                                System.out.println("\nString before: " + str);
                                System.out.println("String after:  " + result);
                            }
                            else
                                System.out.println("\nIncorrect input");
                        }
                        case "11" -> flag = true;
                        case "0" -> {
                            System.out.println("\nClose program...");
                            return;
                        }
                        default -> System.out.println("\nIncorrect input");
                    }
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
        System.out.println("1. Make reverse the string");
        System.out.println("2. Make reverse all words in the string");
        System.out.println("3. Make reverse in substring in the string");
        System.out.println("4. Make reverse all words in substring in the string");
        System.out.println("5. Make reverse in substring with first and last index in the string");
        System.out.println("6. Make reverse all words in substring with first and last index in the string");
        System.out.println("7. Make reverse in substring with first and last symbol in the string");
        System.out.println("8. Make reverse all words in substring with first and last symbol in the string");
        System.out.println("9. Make reverse in substring with first and last substring in the string");
        System.out.println("10. Make reverse all words in substring with first and last substring in the string");
        System.out.println("11. Change string");
        System.out.println("0. Exit");
        System.out.print(">> ");
    }
}
