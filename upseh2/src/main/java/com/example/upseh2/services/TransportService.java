package com.example.upseh2.services;

import com.example.upseh2.dtos.TransportDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransportService {
    Page<TransportDTO> getAllTransports(Pageable pageable);

    TransportDTO addTransport(TransportDTO transportDTO);

    void delTransport(long id);

    TransportDTO updateTransport(long id, TransportDTO newTransportDTO);

    TransportDTO findById(long id);
 }
