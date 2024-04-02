package com.example.upseh2.services;

import com.example.upseh2.entities.DeliveryMethod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeliveryMethodService {
    Page<DeliveryMethod> getDeliveryMethod(Pageable pageable);

    DeliveryMethod addDeliveryMethod(DeliveryMethod deliveryMethod);

    void delDeliveryMethod(long id);

    DeliveryMethod updateDeliveryMethod(long id, DeliveryMethod deliveryMethod);

    DeliveryMethod findById(long id);
}
