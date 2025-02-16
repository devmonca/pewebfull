package com.devmonca.pewebfull.controllers;

import com.devmonca.pewebfull.dto.LoginRequestDTO;
import com.devmonca.pewebfull.dto.RegisterRequestDTO;
import com.devmonca.pewebfull.entities.User;
import com.devmonca.pewebfull.infra.security.TokenService;
import com.devmonca.pewebfull.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        User user = this.repository.findByEmail(body.email()).orElseThrow(()-> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.senha(), user.getSenha())){
            String token = this.tokenService.generateUser(user);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<User> user = this.repository.findByEmail(body.email());
        if(user.isEmpty()){
            User newUser = new User();
            newUser.setEmail(body.email());
            newUser.setSenha(passwordEncoder.encode(body.senha()));
            newUser.setNome(body.name());
            this.repository.save(newUser);
            String token = this.tokenService.generateUser(newUser);
            return ResponseEntity.ok(token);
        }

        return ResponseEntity.badRequest().build();
    }
}
