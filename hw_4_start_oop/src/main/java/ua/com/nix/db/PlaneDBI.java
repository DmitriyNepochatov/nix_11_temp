package ua.com.nix.db;

import ua.com.nix.array.ArrayList;
import ua.com.nix.entity.Plane;

public interface PlaneDBI
{
    void create(Plane plane);

    void update(Plane plane);

    void delete(String id);

    Plane findById(String id);

    ArrayList<Plane> findAll();
}
