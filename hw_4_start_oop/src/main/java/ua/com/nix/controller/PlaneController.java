package ua.com.nix.controller;

import ua.com.nix.array.ArrayList;
import ua.com.nix.entity.Plane;
import ua.com.nix.entity.PlaneBrand;
import ua.com.nix.service.PlaneService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class PlaneController
{
    private static final PlaneService planeService = new PlaneService();

    private PlaneController() {}

    public static void run()
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            while (true)
            {
                menu();
                switch (reader.readLine())
                {
                    case "1" -> create(reader);
                    case "2" -> update(reader);
                    case "3" -> delete(reader);
                    case "4" -> findById(reader);
                    case "5" -> findAll();
                    case "0" -> {
                        System.out.println("Close program...");
                        System.exit(0);
                    }
                    default -> System.out.println("\nIncorrect input");
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
        System.out.println("\n1. Create plane");
        System.out.println("2. Update plane");
        System.out.println("3. Delete plane");
        System.out.println("4. Find plane by id");
        System.out.println("5. Show all planes in DB");
        System.out.println("0. Exit");
        System.out.print(">> ");
    }

    private static void create(BufferedReader reader)
    {
        try
        {
            System.out.print("Enter a plane brand (Boeing, Bell, Lockheed, McDonnell, Lancair) >> ");
            String brand = reader.readLine();
            System.out.print("Enter a plane model >> ");
            String model = reader.readLine();
            System.out.print("Enter a number of passengers >> ");
            int numberOfPassengers = Integer.parseInt(reader.readLine());
            System.out.print("Enter a weight of the transported cargo (tons) >> ");
            double weightOfTheTransportedCargo = Double.parseDouble(reader.readLine());
            System.out.print("Enter a number of crew >> ");
            int numberOfCrew = Integer.parseInt(reader.readLine());

            PlaneBrand planeBrand = PlaneBrand.valueOf(brand);
            Plane plane = new Plane();
            plane.setPlaneBrand(planeBrand);
            plane.setPlaneModel(model);
            plane.setNumberOfPassenger(numberOfPassengers);
            plane.setWeightOfTheTransportedCargo(weightOfTheTransportedCargo);
            plane.setNumberOfCrew(numberOfCrew);

            boolean flag = false;
            ArrayList<Plane> arrayList = planeService.findAll();
            for (int i = 0; i < arrayList.size(); i++)
            {
                if (arrayList.get(i).getPlaneBrand().equals(plane.getPlaneBrand()) &&
                        arrayList.get(i).getPlaneModel().equals(plane.getPlaneModel()) &&
                        arrayList.get(i).getNumberOfPassenger() == plane.getNumberOfPassenger() &&
                        arrayList.get(i).getWeightOfTheTransportedCargo() == plane.getWeightOfTheTransportedCargo() &&
                        arrayList.get(i).getNumberOfCrew() == plane.getNumberOfCrew())
                {
                    flag = true;
                }
            }

            if (flag)
            {
                System.out.println("\nThis plane already exists");
            }
            else
            {
                planeService.create(plane);
                System.out.println("\nThe plane has been successfully created");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void update(BufferedReader reader)
    {
        try
        {
            System.out.print("Enter a plane id >> ");
            String id = reader.readLine();
            System.out.print("Enter a plane brand (Boeing, Bell, Lockheed, McDonnell, Lancair) >> ");
            String brand = reader.readLine();
            System.out.print("Enter a plane model >> ");
            String model = reader.readLine();
            System.out.print("Enter a number of passengers >> ");
            int numberOfPassengers = Integer.parseInt(reader.readLine());
            System.out.print("Enter a weight of the transported cargo (tons) >> ");
            double weightOfTheTransportedCargo = Double.parseDouble(reader.readLine());
            System.out.print("Enter a number of crew >> ");
            int numberOfCrew = Integer.parseInt(reader.readLine());

            PlaneBrand planeBrand = PlaneBrand.valueOf(brand);
            Plane plane = new Plane();
            plane.setId(id);
            plane.setPlaneBrand(planeBrand);
            plane.setPlaneModel(model);
            plane.setNumberOfPassenger(numberOfPassengers);
            plane.setWeightOfTheTransportedCargo(weightOfTheTransportedCargo);
            plane.setNumberOfCrew(numberOfCrew);

            if (planeService.findById(plane.getId()) == null)
            {
                System.out.println("This id doesn't exist");
            }
            else
            {
                planeService.update(plane);
                System.out.println("The plane has been successfully updated");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void delete(BufferedReader reader)
    {
        try
        {
            System.out.print("Enter a plane id >> ");
            String id = reader.readLine();

            if (planeService.findById(id) == null)
            {
                System.out.println("This id doesn't exist");
            }
            else
            {
                planeService.delete(id);
                System.out.println("The plane has been successfully deleted");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void findById(BufferedReader reader)
    {
        try
        {
            System.out.print("Enter a plane id >> ");
            String id = reader.readLine();

            Plane plane = planeService.findById(id);

            if (plane == null)
            {
                System.out.println("This id wasn't found");
            }
            else
            {
                System.out.println(plane);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void findAll()
    {
        try
        {
            ArrayList<Plane> arrayList = planeService.findAll();

            if (arrayList.isEmpty())
            {
                System.out.println("DB is empty");
            }
            else
            {
                System.out.println("Planes: ");
                for (int i = 0; i < arrayList.size(); i++)
                {
                    System.out.println(arrayList.get(i));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
