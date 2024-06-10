package com.example.upseh2.services.impl;

import com.example.upseh2.dtos.ClientDTO;
import com.example.upseh2.entities.Auth;
import com.example.upseh2.entities.Balance;
import com.example.upseh2.entities.Client;
import com.example.upseh2.mappers.ClientMapper;
import com.example.upseh2.repositories.AuthRepository;
import com.example.upseh2.repositories.ClientRepository;
import com.example.upseh2.services.BalanceService;
import com.example.upseh2.services.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final BalanceService balanceService;
    private final AuthRepository authRepository;

    public Page<ClientDTO> getClients(Pageable pageable) {
        return clientRepository.findAll(pageable)
                .map(clientMapper::toClientDTO);

    }

    public ClientDTO addClient(ClientDTO clientDTO) {
        if (authRepository.findByLogin(clientDTO.getAuth().getLogin()) != null)
            return null;
        authRepository.save(clientDTO.getAuth());
        Client client = clientMapper.toClient(clientDTO);
        Balance balance = balanceService.addBalance(client.getBalance().getBalance());
        client.setBalance(balance);
        clientRepository.save(client);
        return clientMapper.toClientDTO(client);
    }

    public void delClient(long id) {
        clientRepository.deleteById(id);
    }

    public ClientDTO updateClient(long id, ClientDTO updateClientDTO) {
        Optional<Client> optionalUser = clientRepository.findById(id);
        Client client = optionalUser.orElseGet(() -> null);

        if (client == null) {
            return null;
        }

        Auth auth = client.getAuthentication();
        String login = updateClientDTO.getAuth().getLogin();
        String password = updateClientDTO.getAuth().getPassword();

        if (!auth.getLogin().equals(login)) {
            if (authRepository.findByLogin(login) != null)
                return null;
            auth.setLogin(login);
        }
        if (!auth.getPassword().equals(password))
            auth.setPassword(password);

        authRepository.save(auth);
        client.setAuthentication(auth);

        client.setSurname(updateClientDTO.getSurname());
        Balance balance = balanceService.findById(clientRepository.findById(id).orElseThrow().getBalance().getId());
        balance.setBalance(updateClientDTO.getBalance());
        balanceService.updateBalance(balance.getId(), balance.getBalance());
        client.setBalance(balance);
        return clientMapper.toClientDTO(clientRepository.save(client));
    }

    public ClientDTO findById(long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toClientDTO)
                .orElseThrow();
    }

    public Client findByLogin(UserDetails userDetails) {
        Auth auth = authRepository.findByLogin(userDetails.getUsername());
        long longValue = auth.getId();
        return clientRepository.findById(longValue)
                .orElseThrow(() -> new NoSuchElementException("Client not found for login: " + auth));
    }
}