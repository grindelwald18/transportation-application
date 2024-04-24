package com.example.upseh2.controllers;

import com.example.upseh2.dtos.TransportDTO;
import com.example.upseh2.services.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transport")
@RequiredArgsConstructor
public class TransportController {
    private final TransportService transportService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<TransportDTO> getAllTransports(Pageable pageable){
        return transportService.getAllTransports(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransportDTO getTransportById(@PathVariable long id){
        return transportService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransportDTO addTransport(@RequestBody TransportDTO TransportDTO) {
        return transportService.addTransport(TransportDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delTransport(@PathVariable long id) {
        transportService.delTransport(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransportDTO updateTransport(@PathVariable long id, @RequestBody TransportDTO TransportDTO) {
        return transportService.updateTransport(id, TransportDTO);
    }
}
