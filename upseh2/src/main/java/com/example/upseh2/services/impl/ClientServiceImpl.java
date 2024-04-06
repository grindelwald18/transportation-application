package com.example.upseh2.services.impl;

import com.example.upseh2.dtos.ClientDTO;
import com.example.upseh2.entities.Client;
import com.example.upseh2.mappers.ClientMapper;
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
    private final ClientMapper clientMapper;
    public Page<ClientDTO> getClients(Pageable pageable) {
        return  clientRepository.findAll(pageable)
                .map(clientMapper::toClientDTO);

    }
    public ClientDTO addClient(Client client){
        return clientMapper.toClientDTO(clientRepository.save(client));
    }
    public void delClient(long id){
        clientRepository.deleteById(id);
    }
    public ClientDTO updateClient(long id, Client updateClient){
        updateClient.setId(id);
        return clientMapper.toClientDTO(clientRepository.save(updateClient));
    }
    public ClientDTO findClientById(long id){
        return clientRepository.findById(id)
                .map(clientMapper::toClientDTO)
                .orElseThrow();
    }
}