package com.example.upseh2.mappers;

import com.example.upseh2.dtos.TransporterDTO;
import com.example.upseh2.entities.Transporter;
import org.mapstruct.Mapper;

@Mapper
public interface TransporterMapper {
    Transporter toTransporter(TransporterDTO transporterDTO);
    TransporterDTO toTransporterDTO(Transporter transporter);
}