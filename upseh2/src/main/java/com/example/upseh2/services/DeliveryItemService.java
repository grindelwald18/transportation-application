package com.example.upseh2.services;

import com.example.upseh2.dtos.DeliveryItemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeliveryItemService {
    Page<DeliveryItemDTO> getDeliveryItem(Pageable pageable);

    DeliveryItemDTO addDeliveryItem(DeliveryItemDTO DeliveryItemDTO);

    void delDeliveryItem(long id);

    DeliveryItemDTO updateDeliveryItem(long id, DeliveryItemDTO updateDeliveryItemDTO);

    DeliveryItemDTO findById(long id);
}
