package com.example.upseh2.mappers;

import com.example.upseh2.dtos.ClientDTO;
import com.example.upseh2.entities.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {
    Client toClient(ClientDTO clientDTO);
    ClientDTO toClientDTO(Client client);
}
