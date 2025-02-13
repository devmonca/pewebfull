package com.devmonca.pewebfull.controllers;

import com.devmonca.pewebfull.entities.User;
import com.devmonca.pewebfull.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Listar usuário
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.status(200).body(userService.findAll());
    }

    // Criar usuario
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.status(200).body(userService.createUser(user));
    }

    // Editar usuário
    @PutMapping
    public ResponseEntity<User> editUser(@RequestBody User user){
        return ResponseEntity.status(201).body(userService.editUser(user));
    }

    // Deletar usuario
    @DeleteMapping(value= "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).build();
    }
}
