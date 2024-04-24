package com.example.upseh2.services.impl;

import com.example.upseh2.dtos.DeliveryItemDTO;
import com.example.upseh2.entities.DeliveryItem;
import com.example.upseh2.mappers.DeliveryItemMapper;
import com.example.upseh2.repositories.DeliveryItemRepository;
import com.example.upseh2.services.DeliveryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryItemServiceImpl implements DeliveryItemService {
    private final DeliveryItemRepository deliveryItemRepository;
    private final DeliveryItemMapper deliveryItemMapper;

    public Page<DeliveryItemDTO> getDeliveryItem(Pageable pageable) {
        return deliveryItemRepository.findAll(pageable)
                .map(deliveryItemMapper::toDeliveryItemDTO);
    }

    public DeliveryItemDTO addDeliveryItem(DeliveryItemDTO deliveryItemDTO) {
        DeliveryItem deliveryItem = deliveryItemMapper.toDeliveryItem(deliveryItemDTO);
        return deliveryItemMapper.toDeliveryItemDTO(deliveryItemRepository.save(deliveryItem));
    }

    public void delDeliveryItem(long id) {
        deliveryItemRepository.deleteById(id);
    }

    public DeliveryItemDTO updateDeliveryItem(long id, DeliveryItemDTO updateDeliveryItemDTO) {
        DeliveryItem updateDeliveryItem = deliveryItemMapper.toDeliveryItem(updateDeliveryItemDTO);
        updateDeliveryItem.setId(id);
        return deliveryItemMapper.toDeliveryItemDTO(deliveryItemRepository.save(updateDeliveryItem));
    }


    public DeliveryItemDTO findById(long id) {
        return deliveryItemRepository.findById(id)
                .map(deliveryItemMapper::toDeliveryItemDTO)
                .orElseThrow();
    }
}
