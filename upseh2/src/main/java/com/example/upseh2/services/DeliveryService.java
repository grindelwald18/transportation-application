package com.example.upseh2.services;


import com.example.upseh2.entities.Delivery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeliveryService {
    Page<Delivery> getDelivery(Pageable pageable);

    Delivery addDelivery(Delivery delivery);

    void delDelivery(long id);

    Delivery updateDelivery(long id, Delivery updateDelivery);

    Delivery findById(long id);
}
