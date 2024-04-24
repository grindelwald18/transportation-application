package com.example.upseh2.services;

import com.example.upseh2.dtos.TransporterDTO;
import com.example.upseh2.entities.Transporter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransporterService {
    Page<TransporterDTO> getAllTransporters(Pageable pageable);

    TransporterDTO addTransporter(TransporterDTO transporterDTO);

    void delTransporter(long id);

    TransporterDTO updateTransporter(long id, TransporterDTO newTransporterDTO);

    TransporterDTO findById(long id);
}
