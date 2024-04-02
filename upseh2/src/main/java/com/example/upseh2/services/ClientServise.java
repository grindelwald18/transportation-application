package com.example.upseh2.services;

import com.example.upseh2.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientServise {
    Page<Client> getClients(Pageable pageable);

    Client addClient(Client client);

    void delClient(long id);

    Client updateClient(long id, Client updateClient);

    Client findClientById(long id);
}
