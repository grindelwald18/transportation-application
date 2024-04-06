package com.example.upseh2.services.impl;

import com.example.upseh2.dtos.DeliveryMethodDTO;
import com.example.upseh2.entities.DeliveryMethod;
import com.example.upseh2.mappers.DeliveryMethodMapper;
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
    private final DeliveryMethodMapper deliveryMethodMapper;
    public Page<DeliveryMethodDTO> getDeliveryMethod(Pageable pageable) {
        return deliveryMethodRepository.findAll(pageable)
                .map(deliveryMethodMapper::toDeliveryMethodDTO);
    }

    public DeliveryMethodDTO addDeliveryMethod(DeliveryMethod deliveryMethod) {
        return deliveryMethodMapper.toDeliveryMethodDTO(deliveryMethodRepository.save(deliveryMethod));
    }

    public void delDeliveryMethod(long id) {
        deliveryMethodRepository.deleteById(id);
    }

    public DeliveryMethodDTO updateDeliveryMethod(long id, DeliveryMethod updareDeliveryMethod) {
        updareDeliveryMethod.setId(id);
        return deliveryMethodMapper.toDeliveryMethodDTO(deliveryMethodRepository.save(updareDeliveryMethod));

    }

    public DeliveryMethodDTO findById(long id) {
        return deliveryMethodRepository.findById(id)
                .map(deliveryMethodMapper::toDeliveryMethodDTO)
                .orElseThrow();
    }

}