package ua.com.nix.service;

import ua.com.nix.array.ArrayList;
import ua.com.nix.dao.PlaneDao;
import ua.com.nix.dao.PlaneDaoImpl;
import ua.com.nix.entity.Plane;

public class PlaneService
{
    private PlaneDao planeDao = new PlaneDaoImpl();

    public void create(Plane plane)
    {
        planeDao.create(plane);
    }

    public void update(Plane plane)
    {
        if (checkExistId(plane.getId()))
        {
            planeDao.update(plane);
            System.out.println("The plane has been successfully updated");
        }
    }

    public void delete(String id)
    {
        if (checkExistId(id))
        {
            planeDao.delete(id);
            System.out.println("The plane has been successfully deleted");
        }
    }

    public Plane findById(String id)
    {
        return planeDao.findById(id);
    }

    public ArrayList<Plane> findAll()
    {
        return planeDao.findAll();
    }

    private boolean checkExistId(String id)
    {
        if (findById(id) == null)
        {
            System.out.println("This id doesn't exist");
            return false;
        }
        return true;
    }
}
