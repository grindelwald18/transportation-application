package com.example.upseh2.controllers;

import com.example.upseh2.dtos.ClientDTO;
import com.example.upseh2.dtos.RequestData;
import com.example.upseh2.entities.Client;
import com.example.upseh2.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ClientDTO> getClients(Pageable pageable) {
        return clientService.getClients(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDTO findById(@PathVariable long id) {
        return clientService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO addClient(@RequestBody ClientDTO clientDTO) {
        return clientService.addClient(clientDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delClient(@PathVariable long id) {
        clientService.delClient(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDTO updateClient(@PathVariable long id, @RequestBody ClientDTO clientDTO) {
        return clientService.updateClient(id, clientDTO);
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public Client findByLogin(@AuthenticationPrincipal UserDetails userDetails) {
        return clientService.findByLogin(userDetails);
    }
}
