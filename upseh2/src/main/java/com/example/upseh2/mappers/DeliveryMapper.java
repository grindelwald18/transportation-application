package com.example.upseh2.mappers;

import com.example.upseh2.dtos.DeliveryDTO;
import com.example.upseh2.entities.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DeliveryMapper {
    @Mapping(source = "clientId", target = "client.id")
    @Mapping(source = "transportId", target = "transport.id")
    @Mapping(source = "container", target = "container") // Исправлено на имя свойства без уточнения типа
    Delivery toDelivery(DeliveryDTO deliveryDTO);

    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "transport.id", target = "transportId")
    @Mapping(source = "container", target = "container") // Исправлено на имя свойства без уточнения типа
    DeliveryDTO toDeliveryDTO(Delivery delivery);
}
