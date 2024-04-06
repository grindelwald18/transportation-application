package com.example.upseh2.services.impl;

import com.example.upseh2.dtos.DeliveryDTO;
import com.example.upseh2.entities.Delivery;
import com.example.upseh2.mappers.DeliveryMapper;
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
    private final DeliveryMapper deliveryMapper;

    public Page<DeliveryDTO> getDelivery(Pageable pageable) {
        return deliveryRepository.findAll(pageable)
                .map(deliveryMapper::toDeliveryDTO);
    }

    public DeliveryDTO addDelivery(Delivery delivery) {
        return deliveryMapper.toDeliveryDTO(deliveryRepository.save(delivery));
    }

    public void delDelivery(long id) {
        deliveryRepository.deleteById(id);
    }

    public DeliveryDTO updateDelivery(long id, Delivery updateDelivery){
        updateDelivery.setId(id);
        return deliveryMapper.toDeliveryDTO(deliveryRepository.save(updateDelivery));
    }

    public DeliveryDTO findById (long id) {
        return deliveryRepository.findById(id)
                .map(deliveryMapper::toDeliveryDTO)
                .orElseThrow();
    }

}