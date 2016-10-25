package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.User;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan_Lohvinau on 10/24/2016.
 */
public class UserDAO implements DAO<User, Long> {
    private Map<Long, User> userMap = new HashMap<>();
    private Long lastInsertId = 5l;

    public UserDAO() {
        for (Long i = 1l; i <= 5l; i++) {
            User user = new User();
            user.setEmail("fox2205");
            user.setFirstName("Ivan");
            user.setLastName("Logvinov");
            user.setBirthDate(LocalDate.of(1995,9,28));
            user.setId(i);
            userMap.put(i, user);
        }
    }

    @Override
    public Long add(User instance) {
        userMap.put(lastInsertId++, instance);
        return lastInsertId;
    }

    @Override
    public boolean delete(Long id) {
        return true;
    }

    @Override
    public boolean update(User updateInstance) {
        return true;
    }

    @Override
    public User readByID(Long id) {
        return userMap.get(id);
    }

    public User findByEmail(String email) {
        return userMap.values().stream().filter(p -> p.getEmail().equals(email)).findFirst().orElse(null);
    }

    public Collection<User> findAll(){
        return userMap.values();
    }

}
