package com.example.upseh2.mappers;

import com.example.upseh2.dtos.DeliveryDTO;
import com.example.upseh2.entities.Delivery;
import org.mapstruct.Mapper;

@Mapper
public interface DeliveryMapper {
    Delivery toDelivery(DeliveryDTO deliveryDTO);
    DeliveryDTO toDeliveryDTO(Delivery delivery);
}
