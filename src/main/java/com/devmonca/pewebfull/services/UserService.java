package com.devmonca.pewebfull.services;

import com.devmonca.pewebfull.entities.User;
import com.devmonca.pewebfull.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(UserRepository repository){
        this.userRepository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User editUser(User editUser){
        User existingUser = userRepository.findById(Long.valueOf(editUser.getId())).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if(existingUser.getSenha().equals(editUser.getSenha())){
            String passwordEncoded = this.passwordEncoder.encode(editUser.getSenha());
            editUser.setSenha(passwordEncoded);
        }
        return userRepository.save(editUser);
    }

}
