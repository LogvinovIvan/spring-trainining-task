package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Auditorium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Ivan_Lohvinau on 10/25/2016.
 */
public class AuditoriumDAO implements DAO<Auditorium, Long> {
    private Map<Long, Auditorium> auditoriumMap = new HashMap<>();
    private Long lastInsertId = 0l;

    public AuditoriumDAO() {
        Auditorium auditorium = new Auditorium();
        auditorium.setName("stadium");
        auditorium.setNumberOfSeats(40000);
        Set<Long> vipSets = new HashSet<>();
        for (int i = 0; i <= 1000; i++) {
            vipSets.add((long) i);
        }
        auditorium.setVipSeats(vipSets);
        auditoriumMap.put(++lastInsertId, auditorium);
    }

    @Override
    public Long add(Auditorium instance) {
        ++lastInsertId;
        instance.setId(lastInsertId);
        auditoriumMap.put(lastInsertId, instance);
        return lastInsertId;
    }

    @Override
    public boolean delete(Long id) {
        boolean result = false;
        if (auditoriumMap.containsKey(id)) {
            auditoriumMap.remove(id);
            result = true;
        }
        return result;
    }

    @Override
    public boolean update(Auditorium updateInstance) {
        boolean result = false;
        if (auditoriumMap.containsKey(updateInstance.getId())) {
            auditoriumMap.put(updateInstance.getId(), updateInstance);
            result = true;
        }
        return result;
    }

    @Override
    public Auditorium readByID(Long id) {
        return auditoriumMap.get(id);
    }

    public Set<Auditorium> findAllAuditorium(){
        return new HashSet<>(auditoriumMap.values());
    }

    public Auditorium findByName(String name){
        return  auditoriumMap.values().stream().filter(p->p.getName().equals(name)).findFirst().orElse(null);
    }
}
