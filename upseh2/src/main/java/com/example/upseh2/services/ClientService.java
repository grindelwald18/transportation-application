package com.example.upseh2.services;

import com.example.upseh2.dtos.ClientDTO;
import com.example.upseh2.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

public interface ClientService {
    Page<ClientDTO> getClients(Pageable pageable);

    ClientDTO addClient(ClientDTO clientDTO);

    void delClient(long id);

    ClientDTO updateClient(long id, ClientDTO updateClientDTO);

    ClientDTO findById(long id);

    Client findByLogin(UserDetails userDetails);
}
