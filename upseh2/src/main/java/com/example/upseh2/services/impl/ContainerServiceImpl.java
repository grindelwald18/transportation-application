package com.example.upseh2.services.impl;

import com.example.upseh2.dtos.ContainerDTO;
import com.example.upseh2.entities.Container;
import com.example.upseh2.entities.DeliveryItem;
import com.example.upseh2.mappers.ContainerMapper;
import com.example.upseh2.repositories.ContainerRepository;
import com.example.upseh2.repositories.DeliveryItemRepository;
import com.example.upseh2.services.ContainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ContainerServiceImpl implements ContainerService {

    private final ContainerRepository containerRepository;
    private final ContainerMapper containerMapper;
    private final DeliveryItemRepository deliveryItemRepository;

    public Page<Container> getContainers(Pageable pageable) {
        return containerRepository.findAll(pageable);
    }

    public Container addContainer(ContainerDTO containerDTO) {
//        Container container = containerMapper.toContainer(containerDTO);
        Container container = new Container();
        List<DeliveryItem> deliveryItems = new ArrayList<>();
        containerDTO.getDeliveryItems().forEach(item -> {
            DeliveryItem deliveryItem = deliveryItemRepository.findById(item.getDelivery_item_id()).orElseThrow();
            deliveryItem.setContainer(container);
            deliveryItems.add(deliveryItem);
        });
        container.setDeliveryItems(deliveryItems);
//        return containerMapper.toContainerDTO(containerRepository.save(container));
        containerRepository.save(container);
        return container;
    }

    public void delContainer(long id) {
        containerRepository.deleteById(id);
    }

    public Container updateContainer(long id, ContainerDTO updateContainerDTO) {
//        Container updateContainer = containerMapper.toContainer(updateContainerDTO);\
        deliveryItemRepository.findByContainerId(id).forEach(container -> {
            container.setContainer(null);
        });
        Container updateContainer = new Container();
        updateContainer.setId(id);
        List<DeliveryItem> deliveryItems = new ArrayList<>();
        updateContainerDTO.getDeliveryItems().forEach(item -> {
            DeliveryItem deliveryItem = deliveryItemRepository.findById(item.getDelivery_item_id()).orElseThrow();
            deliveryItem.setContainer(updateContainer);
            deliveryItems.add(deliveryItem);
        });
        updateContainer.setDeliveryItems(deliveryItems);
        return containerRepository.save(updateContainer);
    }

    public Container findById(long id) {
        return containerRepository.findById(id).orElseThrow();
    }
}
