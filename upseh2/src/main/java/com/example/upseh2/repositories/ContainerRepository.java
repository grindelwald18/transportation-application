package com.example.upseh2.repositories;

import com.example.upseh2.entities.Container;
import com.example.upseh2.entities.DeliveryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {
    List<Container> findByDeliveryId(long id);
}
