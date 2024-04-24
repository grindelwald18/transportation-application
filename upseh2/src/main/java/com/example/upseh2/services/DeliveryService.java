package com.example.upseh2.services;


import com.example.upseh2.dtos.DeliveryDTO;
import com.example.upseh2.entities.Delivery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeliveryService {
    Page<Delivery> getDelivery(Pageable pageable);

    Delivery addDelivery(DeliveryDTO deliveryDTO);

    void delDelivery(long id);

    Delivery updateDelivery(long id, DeliveryDTO updateDeliveryDTO);

    Delivery findById(long id);
}
