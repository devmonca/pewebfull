package com.devmonca.pewebfull.repositories;

import com.devmonca.pewebfull.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Integer id(Integer id);
    Optional<User> findByEmail(String email);
}
