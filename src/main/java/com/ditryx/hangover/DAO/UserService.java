package com.ditryx.hangover.DAO;

import com.ditryx.hangover.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById (long id);
    void save(User user);
    void delete(long id);
    User findByLogin (String login);
    User register(User user);

}
