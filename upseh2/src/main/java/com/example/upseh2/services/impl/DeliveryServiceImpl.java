package com.example.upseh2.services.impl;

import com.example.upseh2.dtos.DeliveryDTO;
import com.example.upseh2.entities.*;
import com.example.upseh2.mappers.DeliveryMapper;
import com.example.upseh2.repositories.*;
import com.example.upseh2.services.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;
    private final DeliveryItemRepository deliveryItemRepository;
    private final ContainerRepository containerRepository;
    private final AuthRepository authRepository;
    private final ClientRepository clientRepository;
    private final CargoRepository cargoRepository;
    private final TransportRepository transportRepository;


    public Page<Delivery> getDelivery(Pageable pageable) {
        return deliveryRepository.findAll(pageable);
    }

    public Delivery addDelivery(DeliveryDTO deliveryDTO, UserDetails userDetails) {
        Delivery delivery = new Delivery();
        delivery.setStartPoint(deliveryDTO.getStartPoint());
        delivery.setFinalPoint(deliveryDTO.getFinalPoint());
        delivery.setDistance(deliveryDTO.getDistance());
        delivery.setStatus("заказан");


        Auth auth = authRepository.findByLogin(userDetails.getUsername());
        long longValue = auth.getId();
        delivery.setClient(clientRepository.findById(longValue)
                .orElseThrow(() -> new NoSuchElementException("Client not found for login: " + auth)));

        Optional<Transport> transportOptional = transportRepository.findById((long)7);
        if (transportOptional.isPresent()) {
            delivery.setTransport(transportOptional.get());
        } else {
            throw new NoSuchElementException("Transport not found for ID: " + deliveryDTO.getTransportId());
        }

        deliveryRepository.save(delivery);

        Container container = new Container();
        container.setDelivery(delivery);
        containerRepository.save(container);

        DeliveryItem deliveryItem = new DeliveryItem();
        deliveryItem.setContainer(container);
        Cargo cargo = new Cargo(deliveryDTO.getLength(), deliveryDTO.getWidth(), deliveryDTO.getHeight(), deliveryDTO.getWeight(), deliveryDTO.getName(), true);
        cargoRepository.save(cargo);
        deliveryItem.setCargo(cargo);
        deliveryItem.setAmount(deliveryDTO.getAmount());
        deliveryItemRepository.save(deliveryItem);

        BigDecimal bigDecimal = BigDecimal.valueOf(deliveryDTO.getDistance()*transportOptional.get().getDeliveryMethod().getTariff());
        delivery.setPrice(bigDecimal);
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
        updateDelivery.setContainer(containers);
        return deliveryRepository.save(updateDelivery);
    }

    public Delivery findById (long id) {
        return deliveryRepository.findById(id).orElseThrow();
    }

}