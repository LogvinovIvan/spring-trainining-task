package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.dao.UserDAO;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 * Created by Ivan_Lohvinau on 10/25/2016.
 */
public class UserServiceImpl implements UserService {
    private UserDAO dao;

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return dao.findByEmail(email);
    }

    @Override
    public User save(@Nonnull User object) {
        Long insertedId = dao.add(object);
        object.setId(insertedId);
        return object;
    }

    @Override
    public void remove(@Nonnull User object) {
        dao.delete(object.getId());
    }

    @Override
    public User getById(@Nonnull Long id) {
        return dao.readByID(id);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return dao.findAll();
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }
}
