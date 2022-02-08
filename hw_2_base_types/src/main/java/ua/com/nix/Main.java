package ua.com.nix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args)
    {
        TaskOne taskOne = new TaskOne();
        TaskTwo taskTwo = new TaskTwo();
        TaskThree taskThree = new TaskThree();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            while (true)
            {
                menu();
                switch (reader.readLine())
                {
                    case "1" -> {
                        System.out.println();
                        taskOne.taskOneMethod();
                    }
                    case "2" -> {
                        System.out.println();
                        taskTwo.taskTwoMethod();
                    }
                    case "3" -> {
                        System.out.println();
                        taskThree.taskThreeMethod();
                    }
                    case "0" -> {
                        System.out.println("\nExit");
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

    public static void menu()
    {
        System.out.println();
        System.out.println("1. Launch task one");
        System.out.println("2. Launch task two");
        System.out.println("3. Launch task three");
        System.out.println("0. Exit");
        System.out.print(">> ");
    }
}