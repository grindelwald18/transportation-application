package com.example.upseh2.mappers;

import com.example.upseh2.dtos.ClientDTO;
import com.example.upseh2.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    @Mapping(source = "balance.balance", target = "balance")
    @Mapping(source = "authentication", target = "auth")
    ClientDTO toClientDTO(Client client);

    @Mapping(source = "balance", target = "balance.balance")
    @Mapping(source = "auth", target = "authentication")
    Client toClient(ClientDTO clientDTO);

}