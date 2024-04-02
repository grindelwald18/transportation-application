package com.example.upseh2.services.impl;

import com.example.upseh2.entities.Transporter;
import com.example.upseh2.repositories.TransporterRepository;
import com.example.upseh2.services.TransportService;
import com.example.upseh2.services.TransporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransporterServiceImpl implements TransporterService {

    public final TransporterRepository transporterRepository;

    public Page<Transporter> getAllTransporters(Pageable pageable) {
        return transporterRepository.findAll(pageable);
    }

    public Transporter addTransporter(Transporter transporter) {
        return transporterRepository.save(transporter);
    }

    public void delTransporter(long id) {
        transporterRepository.deleteById(id);
    }

    public Transporter updateTransporter(long id, Transporter newTransporter) {
        newTransporter.setId(id);
        return transporterRepository.save(newTransporter);
    }

    public Transporter findById(long id) {
        return transporterRepository.findById(id).orElseThrow();
    }

}
