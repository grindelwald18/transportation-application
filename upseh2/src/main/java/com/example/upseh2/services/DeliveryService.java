package com.example.upseh2.services;


import com.example.upseh2.dtos.DeliveryDTO;
import com.example.upseh2.entities.Delivery;
import org.mapstruct.control.MappingControl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

public interface DeliveryService {
    Page<Delivery> getDelivery(Pageable pageable);

    Delivery addDelivery(DeliveryDTO deliveryDTO, UserDetails userDetails);

    Delivery findById(long id);
}
