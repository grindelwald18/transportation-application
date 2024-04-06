package com.example.upseh2.services;

import com.example.upseh2.dtos.RoleDTO;
import com.example.upseh2.dtos.TransportDTO;
import com.example.upseh2.entities.Transport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransportService {
    Page<TransportDTO> getAllTransports(Pageable pageable);

    TransportDTO addTransport(Transport newTransport);

    void delTransport(long id);

    TransportDTO updateTransport(long id, Transport newTransport);

    TransportDTO findById(long id);
 }
