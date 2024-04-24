package com.example.upseh2.repositories;

import com.example.upseh2.entities.Auth;
import com.example.upseh2.entities.Transporter;
import com.example.upseh2.auth.SearchEngineUserByUserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransporterRepository extends JpaRepository<Transporter, Long>, SearchEngineUserByUserAuthentication<Transporter>{
    Optional<Transporter> findByAuthentication(Auth auth);
    default Optional<Transporter> findUserByUserAuthentication(Auth userAuth) {
        return findByAuthentication(userAuth);
    }
}
