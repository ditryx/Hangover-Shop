package com.ditryx.hangover.repos;

import com.ditryx.hangover.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(long id);
    User findUserByLogin(String login);
    void deleteUserById(long id);

}
