package ua.com.nix.gamelife;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class GameOfLife
{
    private static int width;
    private static int height;
    private static int[][] board;

    private GameOfLife() {}

    public static void startGameOfLife()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true)
            {
                height = -1;
                width = -1;

                try
                {
                    System.out.println("Enter size of territory");
                    System.out.print("Width >> ");
                    width = Integer.parseInt(reader.readLine());
                    System.out.print("Height >> ");
                    height = Integer.parseInt(reader.readLine());
                }
                catch (Exception e)
                {
                    System.out.println("Incorrect input");
                    continue;
                }

                if (width <= 0 || height <= 0)
                {
                    System.out.println("Incorrect input");
                    continue;
                }

                board = new int[width][height];

                int valueOfInitialCells = ((width * height) / 4) + (int) (Math.random() * ((width * height) / 2));
                for (int i = 0; i < valueOfInitialCells; i++)
                {
                    setAlive((0 + (int) (Math.random() * width)), (0 + (int) (Math.random() * height)));
                }

                int valueOfCycles = 30 + (int) (Math.random() * 60);
                for (int i = 0; i < valueOfCycles; i++)
                {
                    printTerritory();
                    step();
                }
                printTerritory();
                System.out.println();

                System.out.print("Continue? y/n : ");
                String line = reader.readLine();
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

    private static void printTerritory()
    {
        for (int i = 0; i < width + 2; i++)
            System.out.print("-");

        System.out.println("");

        for (int y = 0; y < height; y++)
        {
            String str = "|";

            for (int x = 0; x < width; x++)
            {
                if (board[x][y] == 0)
                {
                    str += ".";
                }
                else
                {
                    str += "*";
                }
            }

            str += "|";
            System.out.println(str);
        }

        for (int i = 0; i < width + 2; i++)
            System.out.print("-");

        System.out.println("\n");
    }

    private static void setAlive(int x, int y)
    {
        board[x][y] = 1;
    }

    private static int countAliveNeighbours(int x, int y)
    {
        int counter = 0;

        counter += getState(x - 1, y - 1);
        counter += getState(x, y - 1);
        counter += getState(x + 1, y - 1);
        counter += getState(x - 1, y);
        counter += getState(x + 1, y);
        counter += getState(x - 1, y + 1);
        counter += getState(x, y + 1);
        counter += getState(x + 1, y + 1);

        return counter;
    }

    private static int getState(int x, int y)
    {
        if (x < 0 || x >= width)
            return 0;
        if (y < 0 || y >= height)
            return 0;
        return board[x][y];
    }

    private static void step()
    {
        int[][] newTerritory = new int[width][height];

        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                int aliveNeighbours = countAliveNeighbours(x, y);

                if (getState(x, y) == 1)
                {
                    if (aliveNeighbours < 2)
                        newTerritory[x][y] = 0;
                    else if (aliveNeighbours == 2 || aliveNeighbours == 3)
                        newTerritory[x][y] = 1;
                    else if (aliveNeighbours > 3)
                        newTerritory[x][y] = 0;
                }
                else
                {
                    if (aliveNeighbours == 3)
                        newTerritory[x][y] = 1;
                }
            }
        }

        board = newTerritory;
    }
}
