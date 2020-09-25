package com.ditryx.hangover.controllers;

import com.ditryx.hangover.DAO.UserService;
import com.ditryx.hangover.DTO.output.AdminUserDTO;
import com.ditryx.hangover.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("users/{id}")
    public ResponseEntity<AdminUserDTO> getUserById(@PathVariable("id") Long id){
        User user = userService.findById(id);

        if (user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDTO userDTO = AdminUserDTO.fromEntity(user);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }



}
