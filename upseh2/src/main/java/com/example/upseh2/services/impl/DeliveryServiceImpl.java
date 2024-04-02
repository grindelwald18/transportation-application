package com.example.upseh2.services.impl;

import com.example.upseh2.entities.Delivery;
import com.example.upseh2.repositories.DeliveryRepository;
import com.example.upseh2.services.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;


    @Override
    public Page<Delivery> getDelivery(Pageable pageable) {
        return deliveryRepository.findAll(pageable);
    }

    public Delivery addDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public void delDelivery(long id) {
        deliveryRepository.deleteById(id);
    }

    public Delivery updateDelivery(long id, Delivery updateDelivery){
        updateDelivery.setId(id);
        return deliveryRepository.save(updateDelivery);
    }

    public Delivery findById (long id) {
        return deliveryRepository.findById(id).orElseThrow();
    }

}