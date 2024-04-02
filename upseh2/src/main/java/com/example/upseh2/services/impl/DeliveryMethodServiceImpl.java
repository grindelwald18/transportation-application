package com.example.upseh2.services.impl;

import com.example.upseh2.entities.DeliveryMethod;
import com.example.upseh2.repositories.DeliveryMethodRepository;
import com.example.upseh2.services.DeliveryMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryMethodServiceImpl implements DeliveryMethodService {

    private final DeliveryMethodRepository deliveryMethodRepository;

    public Page<DeliveryMethod> getDeliveryMethod(Pageable pageable) {
        return deliveryMethodRepository.findAll(pageable);
    }

    public DeliveryMethod addDeliveryMethod(DeliveryMethod deliveryMethod) {
        return deliveryMethodRepository.save(deliveryMethod);
    }

    public void delDeliveryMethod(long id) {
        deliveryMethodRepository.deleteById(id);
    }

    public DeliveryMethod updateDeliveryMethod(long id, DeliveryMethod updareDeliveryMethod) {
        updareDeliveryMethod.setId(id);
        return deliveryMethodRepository.save(updareDeliveryMethod);

    }

    public DeliveryMethod findById(long id) {
        return deliveryMethodRepository.findById(id).orElseThrow();
    }

}