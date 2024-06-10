package com.example.upseh2.services;

import com.example.upseh2.dtos.TransportDTO;
import com.example.upseh2.entities.Transport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransportService {
    Page<TransportDTO> getAllTransports(Pageable pageable);

    Transport addTransport(TransportDTO transportDTO);

    void delTransport(long id);

    TransportDTO updateTransport(long id, TransportDTO newTransportDTO);

    TransportDTO findById(long id);

 }
