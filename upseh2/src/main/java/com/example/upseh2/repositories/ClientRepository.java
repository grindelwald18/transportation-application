package com.example.upseh2.repositories;

import com.example.upseh2.auth.SearchEngineUserByUserAuthentication;
import com.example.upseh2.entities.Auth;
import com.example.upseh2.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>, SearchEngineUserByUserAuthentication<Client> {
    Optional<Client> findByAuthentication(Auth auth);
    default Optional<Client> findUserByUserAuthentication(Auth userAuth) {
        return findByAuthentication(userAuth);
    }
}
