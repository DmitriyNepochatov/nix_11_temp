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
        planeDao.update(plane);
    }

    public void delete(String id)
    {
        planeDao.delete(id);
    }

    public Plane findById(String id)
    {
        return planeDao.findById(id);
    }

    public ArrayList<Plane> findAll()
    {
        return planeDao.findAll();
    }
}
