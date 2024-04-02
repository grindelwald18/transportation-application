package com.example.upseh2.services;

import com.example.upseh2.entities.Transport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransportService {
    Page<Transport> getAllTransports(Pageable pageable);

    Transport addTransport(Transport newTransport);

    void delTransport(long id);

    Transport updateTransport(long id, Transport newTransport);
 }
