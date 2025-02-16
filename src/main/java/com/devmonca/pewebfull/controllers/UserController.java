package com.devmonca.pewebfull.controllers;

import com.devmonca.pewebfull.entities.User;
import com.devmonca.pewebfull.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("sucesso!");
    }

    @PutMapping
    public ResponseEntity<User> editUser(@RequestBody User user){
        return ResponseEntity.status(201).body(userService.editUser(user));
    }

}
