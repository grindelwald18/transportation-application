package com.example.upseh2.services.impl;

import com.example.upseh2.entities.Client;
import com.example.upseh2.repositories.ClientRepository;
import com.example.upseh2.services.ClientServise;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientServise {
    private final ClientRepository clientRepository;
    public Page<Client> getClients(Pageable pageable) {
        return  clientRepository.findAll(pageable);

    }
    public Client addClient(Client client){
        clientRepository.save(client);
        return client;
    }
    public void delClient(long id){
        clientRepository.deleteById(id);
    }
    public Client updateClient(long id, Client updateClient){
        updateClient.setId(id);
        clientRepository.save(updateClient);
        return updateClient;
    }
    public Client findClientById(long id){
        return clientRepository.findById(id).orElseThrow();
    }
}