package com.example.upseh2.repositories;

import com.example.upseh2.entities.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalaceResitory extends JpaRepository<Balance, Long> {
}
