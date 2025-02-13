package com.devmonca.pewebfull.services;

import com.devmonca.pewebfull.entities.User;
import com.devmonca.pewebfull.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Listar usuarios
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
