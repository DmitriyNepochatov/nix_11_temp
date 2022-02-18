package ua.com.nix.areaoftriangle;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class AreaOfTriangle
{
    private AreaOfTriangle() {}

    public static void findAreaOfTriangle()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true)
            {
                int ax, ay;
                int bx, by;
                int cx, cy;

                try
                {
                    System.out.println("Finding area of a triangle");
                    System.out.println("Point A");
                    System.out.print("Enter x >> ");
                    ax = Integer.parseInt(reader.readLine());
                    System.out.print("Enter y >> ");
                    ay = Integer.parseInt(reader.readLine());
                    System.out.println("Point B");
                    System.out.print("Enter x >> ");
                    bx = Integer.parseInt(reader.readLine());
                    System.out.print("Enter y >> ");
                    by = Integer.parseInt(reader.readLine());
                    System.out.println("Point C");
                    System.out.print("Enter x >> ");
                    cx = Integer.parseInt(reader.readLine());
                    System.out.print("Enter y >> ");
                    cy = Integer.parseInt(reader.readLine());
                }
                catch (Exception e)
                {
                    System.out.println("Incorrect input");
                    continue;
                }

                int ab = (int) Math.sqrt(Math.pow((bx - ax), 2) * Math.pow((by - ay), 2));
                int ac = (int) Math.sqrt(Math.pow((cx - ax), 2) * Math.pow((cy - ay), 2));
                int bc = (int) Math.sqrt(Math.pow((cx - bx), 2) * Math.pow((cy - by), 2));

                if ((ab + ac > bc) || (ac + bc > ab) || (ab + bc > ac))
                {
                    double area = Math.abs((ax - bx) * (cy - by) - (cx - bx) * (ay - by)) / 2.0;
                    System.out.println("Area of a triangle is: " + area);
                }
                else
                {
                    System.out.println("This triangle doesn't exist");
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
}
