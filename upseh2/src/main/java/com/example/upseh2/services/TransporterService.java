package com.example.upseh2.services;

import com.example.upseh2.dtos.TransporterDTO;
import com.example.upseh2.entities.Transport;
import com.example.upseh2.entities.Transporter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransporterService {
    Page<Transporter> getAllTransporters(Pageable pageable);

    TransporterDTO addTransporter(TransporterDTO transporterDTO);

    void delTransporter(long id);

    Transporter updateTransporter(long id, TransporterDTO newTransporterDTO);

    Transporter findById(long id);

    List<Transport> getTransportsList(long id);
}
