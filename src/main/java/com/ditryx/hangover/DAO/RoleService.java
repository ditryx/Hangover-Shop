package com.ditryx.hangover.DAO;

import com.ditryx.hangover.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById (long id);
    void save(Role role);
    void delete(long id);
}
