package ua.epam.spring.hometask.dao;

import java.io.Serializable;

/**
 * Created by Ivan_Lohvinau on 10/24/2016.
 */
public interface DAO<T, PK extends Serializable> {
    PK add(T instance);
    boolean delete(PK id);
    boolean update(T updateInstance);
    T readByID(PK id);
}
