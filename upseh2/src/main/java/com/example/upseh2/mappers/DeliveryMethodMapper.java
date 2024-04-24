package com.example.upseh2.mappers;

import com.example.upseh2.dtos.DeliveryMethodDTO;
import com.example.upseh2.entities.DeliveryMethod;
import org.mapstruct.Mapper;

@Mapper
public interface DeliveryMethodMapper {
    DeliveryMethod toDeliveryMethod(DeliveryMethodDTO deliveryMethodDTO);

    DeliveryMethodDTO toDeliveryMethodDTO(DeliveryMethod deliveryMethod);
}