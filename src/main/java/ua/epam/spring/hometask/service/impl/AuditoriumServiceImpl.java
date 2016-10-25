package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.dao.AuditoriumDAO;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.domain.DomainObject;
import ua.epam.spring.hometask.service.AbstractDomainObjectService;
import ua.epam.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

/**
 * Created by Ivan_Lohvinau on 10/25/2016.
 */
public class AuditoriumServiceImpl implements AuditoriumService, AbstractDomainObjectService<Auditorium> {
    private AuditoriumDAO dao;


    @Override
    public Auditorium save(@Nonnull Auditorium object) {
        Long insertedId = dao.add(object);
        object.setId(insertedId);
        return object;
    }

    @Override
    public void remove(@Nonnull Auditorium object) {
        dao.delete(object.getId());
    }

    @Override
    public Auditorium getById(@Nonnull Long id) {
        return dao.readByID(id);
    }

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return dao.findAllAuditorium();
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return dao.findByName(name);
    }

    public void setDao(AuditoriumDAO dao) {
        this.dao = dao;
    }
}
