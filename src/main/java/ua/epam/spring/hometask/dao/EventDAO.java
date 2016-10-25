package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.EventRating;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;

/**
 * Created by Ivan_Lohvinau on 10/25/2016.
 */
public class EventDAO implements DAO<Event, Long> {
    private static Map<Long, Event> eventMap = new HashMap<>();
    private Long lastInsertId = 0l;

    public EventDAO() {
        AuditoriumDAO dao = new AuditoriumDAO();

        Event event = new Event();
        event.setName("Football");
        event.setBasePrice(20d);
        event.setRating(EventRating.HIGH);

        event.addAirDateTime(LocalDateTime.now());
        event.assignAuditorium(LocalDateTime.now(), dao.readByID(1l));

        eventMap.put(lastInsertId, event);

    }

    @Override
    public Long add(Event instance) {
        lastInsertId++;
        instance.setId(lastInsertId);
        eventMap.put(lastInsertId, instance);
        return lastInsertId;
    }

    @Override
    public boolean delete(Long id) {
        boolean result = false;
        if (eventMap.containsKey(id)) {
            eventMap.remove(id);
            result = true;
        }
        return result;
    }

    @Override
    public boolean update(Event updateInstance) {
        boolean result = false;
        if (eventMap.containsKey(updateInstance.getId())) {
            eventMap.remove(updateInstance.getId());
            result = true;
        }
        return result;
    }

    @Override
    public Event readByID(Long id) {
        return eventMap.get(id);
    }

    public Event findEventByName(String name) {
        return eventMap.values().stream().filter(p -> name.equals(p.getName())).findFirst().orElse(null);
    }

    public Collection<Event> findAll(){
        return eventMap.values();
    }
}
