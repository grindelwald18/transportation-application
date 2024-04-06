package com.example.upseh2.services.impl;

import com.example.upseh2.dtos.TransporterDTO;
import com.example.upseh2.entities.Transporter;
import com.example.upseh2.mappers.TransporterMapper;
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

    private final TransporterRepository transporterRepository;
    private final TransporterMapper transporterMapper;

    public Page<TransporterDTO> getAllTransporters(Pageable pageable) {
        return transporterRepository.findAll(pageable)
                .map(transporterMapper::toTransporterDTO);
    }

    public TransporterDTO addTransporter(Transporter transporter) {
        return transporterMapper.toTransporterDTO(transporterRepository.save(transporter));
    }

    public void delTransporter(long id) {
        transporterRepository.deleteById(id);
    }

    public TransporterDTO updateTransporter(long id, Transporter newTransporter) {
        newTransporter.setId(id);
        return transporterMapper.toTransporterDTO(transporterRepository.save(newTransporter));
    }

    public TransporterDTO findById(long id) {
        return transporterRepository.findById(id)
                .map(transporterMapper::toTransporterDTO)
                .orElseThrow();
    }

}
