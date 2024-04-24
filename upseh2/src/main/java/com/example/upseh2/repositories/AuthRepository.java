package com.example.upseh2.repositories;

import com.example.upseh2.entities.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Integer> {
    Auth findByLogin(String login);
    Auth findByPassword(String password);
}
