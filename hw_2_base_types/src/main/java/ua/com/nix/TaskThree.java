package ua.com.nix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TaskThree
{
    public void taskThreeMethod()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a number of a lesson: ");
            String line = reader.readLine();
            int numberOfLesson = Integer.parseInt(line);

            int temp = numberOfLesson * 45 + (numberOfLesson / 2) * 5 + ((numberOfLesson + 1) / 2 - 1) * 15;
            int hours = temp / 60 + 9;
            int minutes = temp % 60;

            System.out.println("The lesson ends at: " + hours + " : " + minutes);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}