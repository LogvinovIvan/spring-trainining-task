package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.dao.EventDAO;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.service.EventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 * Created by Ivan_Lohvinau on 10/25/2016.
 */
public class EventServiceImpl implements EventService {
    private EventDAO dao;
    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return dao.findEventByName(name);
    }

    @Override
    public Event save(@Nonnull Event object) {
        Long insertedId = dao.add(object);
        object.setId(insertedId);
        return object;
    }

    @Override
    public void remove(@Nonnull Event object) {
        dao.delete(object.getId());
    }

    @Override
    public Event getById(@Nonnull Long id) {
        return dao.readByID(id);
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return dao.findAll();
    }

    public void setDao(EventDAO dao) {
        this.dao = dao;
    }
}
