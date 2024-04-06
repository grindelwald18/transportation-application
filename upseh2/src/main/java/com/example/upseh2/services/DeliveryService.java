package com.example.upseh2.services;


import com.example.upseh2.dtos.DeliveryDTO;
import com.example.upseh2.entities.Delivery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeliveryService {
    Page<DeliveryDTO> getDelivery(Pageable pageable);

    DeliveryDTO addDelivery(Delivery delivery);

    void delDelivery(long id);

    DeliveryDTO updateDelivery(long id, Delivery updateDelivery);

    DeliveryDTO findById(long id);
}
