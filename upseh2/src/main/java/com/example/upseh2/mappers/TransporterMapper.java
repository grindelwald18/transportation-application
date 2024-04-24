package com.example.upseh2.mappers;

import com.example.upseh2.dtos.TransporterDTO;
import com.example.upseh2.entities.Transporter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TransporterMapper {


        @Mapping(source = "auth", target = "authentication")
        Transporter toTransporter(TransporterDTO transporterDTO);

        @Mapping(source = "authentication", target = "auth")
        TransporterDTO toTransporterDTO(Transporter transporter);
}