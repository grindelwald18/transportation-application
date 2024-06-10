package com.example.upseh2.services.impl;

import com.example.upseh2.dtos.TransportDTO;
import com.example.upseh2.entities.DeliveryMethod;
import com.example.upseh2.entities.Transport;
import com.example.upseh2.entities.Transporter;
import com.example.upseh2.mappers.DeliveryMapper;
import com.example.upseh2.mappers.TransportMapper;
import com.example.upseh2.repositories.DeliveryMethodRepository;
import com.example.upseh2.repositories.TransportRepository;
import com.example.upseh2.repositories.TransporterRepository;
import com.example.upseh2.services.TransportService;
import com.example.upseh2.services.TransporterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class TransportServiceImpl implements TransportService {

    private  final TransportRepository transportRepository;
    private  final TransporterRepository transporterRepository;
    private final DeliveryMethodRepository deliveryMethodRepository;
    private final TransportMapper transportMapper;
    public Page<TransportDTO> getAllTransports(Pageable pageable) {
        return transportRepository.findAll(pageable)
                .map(transportMapper::toTransportDTO);
    }

    public Transport addTransport(TransportDTO transportDTO) {
        Transporter transporter = transporterRepository.findById(transportDTO.getTransporterId()).orElseThrow();
        Transport transport = new Transport();
        transport.setTransportName(transportDTO.getTransportName());
        transport.setCapacity(transportDTO.getCapacity());
        transport.setSpeed(transportDTO.getSpeed());
        DeliveryMethod deliveryMethod = deliveryMethodRepository.findById(transportDTO.getDeliveryMethodId()).orElseThrow();
        transport.setDeliveryMethod(deliveryMethod);
        transport.setTransporter(transporter);
        return transportRepository.save(transport);
    }

    public void delTransport(long id) {
        transportRepository.deleteById(id);
    }

    public TransportDTO updateTransport(long id, TransportDTO newTransportDTO) {
        Transport newTransport = transportMapper.toTransport(newTransportDTO);
        newTransport.setId(id);
        return transportMapper.toTransportDTO(transportRepository.save(newTransport));
    }

    public TransportDTO findById(long id) {
        return transportRepository.findById(id)
                .map(transportMapper::toTransportDTO)
                .orElseThrow();
    }
}
