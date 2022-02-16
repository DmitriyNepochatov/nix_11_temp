package ua.com.nix.dao;

import ua.com.nix.array.ArrayList;
import ua.com.nix.entity.AbstractEntity;

public interface AbstractDao<E extends AbstractEntity>
{
    void create(E entity);

    void update(E entity);

    void delete(String id);

    E findById(String id);

    ArrayList<E> findAll();
}
