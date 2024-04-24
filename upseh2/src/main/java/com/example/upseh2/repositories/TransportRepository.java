package com.example.upseh2.repositories;

import com.example.upseh2.entities.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {

}
