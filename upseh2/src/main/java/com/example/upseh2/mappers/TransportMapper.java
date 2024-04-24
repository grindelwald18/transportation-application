package com.example.upseh2.mappers;

import com.example.upseh2.dtos.TransportDTO;
import com.example.upseh2.entities.Transport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TransportMapper {

    @Mapping(source = "deliveryMethodId", target = "deliveryMethod.id")
    @Mapping(source = "transporterId", target = "transporter.id")
    Transport toTransport(TransportDTO transportDTO);

    @Mapping(source = "deliveryMethod.id", target = "deliveryMethodId")
    @Mapping(source = "transporter.id", target = "transporterId")
    TransportDTO toTransportDTO(Transport transport);
}
