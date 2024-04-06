package com.example.upseh2.services.impl;

import com.example.upseh2.dtos.TransportDTO;
import com.example.upseh2.entities.Transport;
import com.example.upseh2.mappers.TransportMapper;
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
    private final TransportMapper transportMapper;
    public Page<TransportDTO> getAllTransports(Pageable pageable) {
        return transportRepository.findAll(pageable)
                .map(transportMapper::toTransportDTO);
    }

    public TransportDTO addTransport(Transport transport) {
        return transportMapper.toTransportDTO(transportRepository.save(transport));
    }

    public void delTransport(long id) {
        transportRepository.deleteById(id);
    }

    public TransportDTO updateTransport(long id, Transport newTransport) {
        newTransport.setId(id);
        return transportMapper.toTransportDTO(transportRepository.save(newTransport));
    }

    public TransportDTO findById(long id) {
        return transportRepository.findById(id)
                .map(transportMapper::toTransportDTO)
                .orElseThrow();
    }
}
