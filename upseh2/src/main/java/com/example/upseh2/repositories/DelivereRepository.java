package com.example.upseh2.repositories;

import com.example.upseh2.entities.Delivere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelivereRepository extends JpaRepository<Delivere, Long> {
}
