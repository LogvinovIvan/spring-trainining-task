package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Ivan_Lohvinau on 10/25/2016.
 */
public class TicketDAO implements DAO<Ticket, Long> {

    private static Map<Long, Ticket> ticketMap = new HashMap<>();
    private Long lastInsertId = 0l;


    @Override
    public Long add(Ticket instance) {

        lastInsertId++;
        ticketMap.put(lastInsertId, instance);

        return lastInsertId;
    }

    @Override
    public boolean delete(Long id) {
        boolean result = false;

        if (ticketMap.containsKey(id)) {
            ticketMap.remove(id);
            result = true;
        }
        return result;
    }

    @Override
    public boolean update(Ticket updateInstance) {
        boolean result = false;

        if (ticketMap.containsKey(updateInstance.getId())) {
            ticketMap.put(updateInstance.getId(), updateInstance);
            result = true;
        }
        return result;
    }

    @Override
    public Ticket readByID(Long id) {
        return ticketMap.get(id);
    }

    public Set<Ticket> findPurchaseTicketOnEvent(Event event, LocalDateTime localDateTime) {
        return ticketMap.values().
                stream().
                filter(p -> p.getDateTime().equals(localDateTime) && p.getEvent().equals(event))
                .collect(Collectors.toSet());
    }
}
