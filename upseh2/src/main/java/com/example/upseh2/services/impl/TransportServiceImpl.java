package com.example.upseh2.services.impl;

import com.example.upseh2.entities.Transport;
import com.example.upseh2.repositories.TransportRepository;
import com.example.upseh2.services.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransportServiceImpl implements TransportService {

    private  final TransportRepository transportRepository;

    public Page<Transport> getAllTransports(Pageable pageable) {
        return transportRepository.findAll(pageable);
    }

    public Transport addTransport(Transport transport) {
        return transportRepository.save(transport);
    }

    public void delTransport(long id) {
        transportRepository.deleteById(id);
    }

    public Transport updateTransport(long id, Transport newTransport) {
        newTransport.setId(id);
        return transportRepository.save(newTransport);
    }

    public Transport findById(long id) {
        return transportRepository.findById(id).orElseThrow();
    }
}
