package com.ditryx.hangover.security.JWT;

import com.ditryx.hangover.entities.Role;
import com.ditryx.hangover.entities.Status;
import com.ditryx.hangover.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user){
        return new JwtUser(
                user.getId(),
                user.getLogin(),
                user.getPasswordHash(),
                user.getFirstName(),
                user.getLastName(),
                user.getMiddleName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getStatus().equals(Status.ACTIVE),
                user.getUpdateDate(),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles()))
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles){
        return userRoles.stream().map(role ->
            new SimpleGrantedAuthority(role.getName())
        ).collect(Collectors.toList());
    }

}
