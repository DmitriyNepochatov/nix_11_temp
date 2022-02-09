package ua.com.nix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class TimeLessonOver
{
    private TimeLessonOver(){}

    public static void makeTimeLessonOver()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;

            while(true)
            {
                boolean flag=false;
                int numberOfLesson=0;

                while (!flag)
                {
                    System.out.print("Enter a number of a lesson: ");
                    line = reader.readLine();
                    switch (line)
                    {
                        case "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" -> {
                            numberOfLesson = Integer.parseInt(line);
                            flag = true;
                        }
                        default -> System.out.println("Wrong input");
                    }
                }

                int temp = numberOfLesson * 45 + (numberOfLesson / 2) * 5 + ((numberOfLesson + 1) / 2 - 1) * 15;
                int hours = temp / 60 + 9;
                int minutes = temp % 60;

                System.out.println("The lesson ends at: " + hours + ":" + minutes);

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