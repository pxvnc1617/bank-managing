package com.example.bank_coding.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //SELECT user FROM user where username = ?
    Optional<User> findByUsername(String username);
}
