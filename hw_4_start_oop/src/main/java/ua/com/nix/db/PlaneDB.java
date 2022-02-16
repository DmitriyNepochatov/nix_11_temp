package ua.com.nix.db;

import ua.com.nix.array.ArrayList;
import ua.com.nix.entity.Plane;
import ua.com.nix.generatorID.GeneratorID;

public final class PlaneDB implements PlaneDBI
{
    private final ArrayList<Plane> planes = new ArrayList<>();
    private static PlaneDB instance;

    private PlaneDB() {}

    public static PlaneDB getInstance()
    {
        if (instance == null)
            instance = new PlaneDB();

        return instance;
    }

    public void create(Plane plane)
    {
        plane.setId(GeneratorID.createID());
        planes.add(plane);
    }

    public void update(Plane plane)
    {
        Plane current = findById(plane.getId());
        current.setPlaneBrand(plane.getPlaneBrand());
        current.setPlaneModel(plane.getPlaneModel());
        current.setNumberOfPassenger(plane.getNumberOfPassenger());
        current.setWeightOfTheTransportedCargo(plane.getWeightOfTheTransportedCargo());
        current.setNumberOfCrew(plane.getNumberOfCrew());
    }

    public void delete(String id)
    {
        for (int i = 0; i < planes.size(); i++)
        {
            if (planes.get(i).getId().equals(id))
            {
                planes.remove(planes.get(i));
            }
        }
    }

    public Plane findById(String id)
    {
        for (int i = 0; i < planes.size(); i++)
        {
            if (planes.get(i).getId().equals(id))
            {
                return planes.get(i);
            }
        }

        return null;
    }

    public ArrayList<Plane> findAll()
    {
        return planes;
    }
}
