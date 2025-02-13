package com.devmonca.pewebfull.services;

import com.devmonca.pewebfull.entities.User;
import com.devmonca.pewebfull.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(UserRepository repository){
        this.userRepository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Listar usuarios
    public List<User> findAll(){
        return userRepository.findAll();
    }

    // Criar usuário
    public User createUser(User newUser){
        String passwordEncoded = this.passwordEncoder.encode(newUser.getSenha());
        newUser.setSenha(passwordEncoded);
        return userRepository.save(newUser);
    }

    // Editar usuario
    public User editUser(User editUser){
//        User existingUser = userRepository.findByEmail(editUser.getEmail().);
        User existingUser = userRepository.findById(Long.valueOf(editUser.getId())).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if(existingUser.getSenha().equals(editUser.getSenha())){
            String passwordEncoded = this.passwordEncoder.encode(editUser.getSenha());
            editUser.setSenha(passwordEncoded);
        }
        return userRepository.save(editUser);
    }

    // Excluir usuário
    public boolean deleteUser(Integer id){
        userRepository.deleteById(Long.valueOf(id));
        return true;
    }
}
