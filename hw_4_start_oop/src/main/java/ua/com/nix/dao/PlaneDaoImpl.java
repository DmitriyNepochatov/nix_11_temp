package ua.com.nix.dao;

import ua.com.nix.array.ArrayList;
import ua.com.nix.db.PlaneDB;
import ua.com.nix.db.PlaneDBI;
import ua.com.nix.entity.Plane;

public class PlaneDaoImpl implements PlaneDao
{
    private final PlaneDBI planeDB = PlaneDB.getInstance();

    @Override
    public void create(Plane entity)
    {
        planeDB.create(entity);
    }

    @Override
    public void update(Plane entity)
    {
        planeDB.update(entity);
    }

    @Override
    public void delete(String id)
    {
        planeDB.delete(id);
    }

    @Override
    public Plane findById(String id)
    {
        return planeDB.findById(id);
    }

    @Override
    public ArrayList<Plane> findAll()
    {
        return planeDB.findAll();
    }
}
