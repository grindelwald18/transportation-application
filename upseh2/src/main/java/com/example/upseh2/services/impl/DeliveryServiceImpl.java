package com.example.upseh2.services.impl;

import com.example.upseh2.dtos.DeliveryDTO;
import com.example.upseh2.entities.Container;
import com.example.upseh2.entities.Delivery;
import com.example.upseh2.entities.DeliveryItem;
import com.example.upseh2.mappers.DeliveryMapper;
import com.example.upseh2.repositories.ClientRepository;
import com.example.upseh2.repositories.ContainerRepository;
import com.example.upseh2.repositories.DeliveryRepository;
import com.example.upseh2.repositories.TransportRepository;
import com.example.upseh2.services.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;
    private final ContainerRepository containerRepository;
    private final ClientRepository clientRepository;
    private final TransportRepository transportRepository;

    public Page<Delivery> getDelivery(Pageable pageable) {
        return deliveryRepository.findAll(pageable);
    }

    public Delivery addDelivery(DeliveryDTO deliveryDTO) {
        Delivery delivery = new Delivery();
        List<Container> containers = new ArrayList<>();
        deliveryDTO.getContainer().forEach(item -> {
            Container container = containerRepository.findById(item.getContainer_id()).orElseThrow();
            container.setDelivery(delivery);
            containers.add(container);
        });
        delivery.setStartPoint(deliveryDTO.getStartPoint());
        delivery.setFinalPoint(deliveryDTO.getFinalPoint());
        delivery.setDistance(deliveryDTO.getDistance());
        delivery.setSendTime(deliveryDTO.getSendTime());
        delivery.setTravelTime(deliveryDTO.getTravelTime());
        delivery.setPrice(deliveryDTO.getPrice());
        delivery.setStatus(deliveryDTO.getStatus());
        delivery.setClient(clientRepository.findById(deliveryDTO.getClientId()).orElseThrow());
        delivery.setTransport(transportRepository.findById(deliveryDTO.getTransportId()).orElseThrow());
        delivery.setContainer(containers);
        deliveryRepository.save(delivery);
        return delivery;
    }

    public void delDelivery(long id) {
        deliveryRepository.deleteById(id);
    }

    public Delivery updateDelivery(long id, DeliveryDTO updateDeliveryDTO){
        containerRepository.findByDeliveryId(id).forEach(container -> {
            container.setDelivery(null);
        });

        Delivery updateDelivery = new Delivery();
        updateDelivery.setId(id);
        List<Container> containers = new ArrayList<>();
        updateDeliveryDTO.getContainer().forEach(item -> {

            Container container = containerRepository.findById(item.getContainer_id()).orElseThrow();
            container.setDelivery(updateDelivery);
            containers.add(container);
        });
        updateDelivery.setContainer(containers);
        return deliveryRepository.save(updateDelivery);
    }

    public Delivery findById (long id) {
        return deliveryRepository.findById(id).orElseThrow();
    }

}