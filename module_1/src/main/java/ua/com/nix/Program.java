package ua.com.nix;

import ua.com.nix.areaoftriangle.AreaOfTriangle;
import ua.com.nix.bracketsstring.BracketsString;
import ua.com.nix.gamelife.GameOfLife;
import ua.com.nix.horsemove.HorseMove;
import ua.com.nix.uniquenumbers.AmountOfUniqueNumbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class Program
{
    private Program() {}

    public static void run()
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            while (true)
            {
                menu();
                switch (reader.readLine())
                {
                    case "1" -> AmountOfUniqueNumbers.findAmountOfUniqueNumbers();
                    case "2" -> HorseMove.makeHorseMove();
                    case "3" -> AreaOfTriangle.findAreaOfTriangle();
                    case "4" -> BracketsString.checkBracketsString();
                    case "5" -> GameOfLife.startGameOfLife();
                    case "0" -> {
                        System.out.println("Close program...");
                        System.exit(0);
                    }
                    default -> System.out.println("Incorrect input");
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
        System.out.println("\n1. Find the number of unique digits in a string");
        System.out.println("2. Make a horse move");
        System.out.println("3. Find the area of a triangle");
        System.out.println("4. Checking a string for validity");
        System.out.println("5. Play the game of life");
        System.out.println("0. Exit");
        System.out.print(">> ");
    }
}
