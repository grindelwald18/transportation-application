package com.example.upseh2.mappers;

import com.example.upseh2.dtos.TransportDTO;
import com.example.upseh2.entities.Transport;
import org.mapstruct.Mapper;

@Mapper
public interface TransportMapper {
    Transport toTransport(TransportDTO transportDTO);
    TransportDTO toTransportDTO(Transport transport);
}