package com.ditryx.hangover.repos;

import com.ditryx.hangover.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleById(long id);

    Role findRoleByName(String name);

    void deleteRoleById(long id);

}
