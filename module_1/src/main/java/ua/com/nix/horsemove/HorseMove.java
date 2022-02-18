package ua.com.nix.horsemove;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class HorseMove
{
    private HorseMove() {}

    public static void makeHorseMove()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int x = -1;
            int y = -1;

            while (true)
            {
                int whereX = -1;
                int whereY = -1;

                if (x == -1 && y == -1)
                {
                    try
                    {
                        System.out.println("we are working with a chessboard 8x8, please enter the starting coordinates of the horse");
                        System.out.print("Enter x >> ");
                        x = Integer.parseInt(reader.readLine());
                        System.out.print("Enter y >> ");
                        y = Integer.parseInt(reader.readLine());

                        if ((x <= -1 || x >= 8) || (y <= -1 || y >= 8))
                        {
                            System.out.println("Incorrect input");
                            x = -1;
                            y = -1;
                            continue;
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("Incorrect input");
                        x = -1;
                        y = -1;
                        continue;
                    }
                }

                try
                {
                    System.out.println("Enter the coordinates where you want to put the horse");
                    System.out.print("Enter x >> ");
                    whereX = Integer.parseInt(reader.readLine());
                    System.out.print("Enter y >> ");
                    whereY = Integer.parseInt(reader.readLine());

                    if ((whereX <= -1 || whereX >= 8) || (whereY <= -1 || whereY >= 8))
                    {
                        System.out.println("Incorrect input");
                        continue;
                    }
                    if (whereX == x && whereY == y)
                    {
                        System.out.println("The horse is already at these coordinates");
                        continue;
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Incorrect input");
                    continue;
                }

                int checkX = Math.abs(x - whereX);
                int checkY = Math.abs(y - whereY);
                if (checkX == 1 && checkY == 2 || checkX == 2 && checkY == 1)
                {
                    System.out.println("Movement is possible");
                    System.out.println();
                    x = whereX;
                    y = whereY;
                    showBoard(x, y);
                    System.out.println();
                }
                else
                {
                    System.out.println("Movement is not possible");
                }

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

    private static void showBoard(int x, int y)
    {
        System.out.print("   0   1   2   3   4   5   6   7  ");
        for (int row = 0; row < 8; row++)
        {
            System.out.println("");
            System.out.println(" ---------------------------------");

            System.out.print(row);
            for (int column = 0; column < 8; column++)
            {
                if (row == y && column == x)
                    System.out.print("| " + "\u265e" + " ");
                else
                    System.out.print("| " + " " + " ");
            }
            System.out.print("|");
        }
        System.out.println("");
        System.out.println(" ---------------------------------");
    }
}
