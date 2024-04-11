package com.example.upseh2.services;

import com.example.upseh2.dtos.ClientDTO;
import com.example.upseh2.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {
    Page<ClientDTO> getClients(Pageable pageable);

    ClientDTO addClient(Client client);

    void delClient(long id);

    ClientDTO updateClient(long id, Client updateClient);

    ClientDTO findById(long id);
}
