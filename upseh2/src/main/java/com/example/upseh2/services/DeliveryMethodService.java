package com.example.upseh2.services;

import com.example.upseh2.dtos.DeliveryMethodDTO;
import com.example.upseh2.entities.DeliveryMethod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeliveryMethodService {
    Page<DeliveryMethodDTO> getDeliveryMethod(Pageable pageable);

    DeliveryMethodDTO addDeliveryMethod(DeliveryMethodDTO deliveryMethodDTO);

    void delDeliveryMethod(long id);

    DeliveryMethodDTO updateDeliveryMethod(long id, DeliveryMethodDTO deliveryMethodDTO);

    DeliveryMethodDTO findById(long id);
}
