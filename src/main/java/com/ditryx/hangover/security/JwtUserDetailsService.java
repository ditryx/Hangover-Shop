package com.ditryx.hangover.security;

import com.ditryx.hangover.DAO.UserService;
import com.ditryx.hangover.entities.User;
import com.ditryx.hangover.security.JWT.JwtUser;
import com.ditryx.hangover.security.JWT.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(@Lazy UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByLogin(username);

        if (user == null){
            throw new UsernameNotFoundException("User with username " + username +" not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        //можно добавить лог об успешном создании
        return jwtUser;
    }
}
