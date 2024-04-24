package com.example.upseh2.mappers;

import com.example.upseh2.dtos.DeliveryItemDTO;
import com.example.upseh2.entities.DeliveryItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DeliveryItemMapper {


    @Mapping(source = "cargoId", target = "cargo.id")
    DeliveryItem toDeliveryItem(DeliveryItemDTO deliveryItemDTO);
    @Mapping(source = "cargo.id", target = "cargoId")
    DeliveryItemDTO toDeliveryItemDTO(DeliveryItem deliveryItem);
}
