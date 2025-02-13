package com.devmonca.pewebfull.repositories;

import com.devmonca.pewebfull.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    Integer id(Integer id);
    User findByEmail(String email);
}
