package com.devmonca.pewebfull.controllers;

import com.devmonca.pewebfull.entities.User;
import com.devmonca.pewebfull.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Listar usuário
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.status(200).body(userService.findAll());
    }
}
