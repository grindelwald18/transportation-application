package com.example.upseh2.services.impl;

import com.example.upseh2.entities.Container;
import com.example.upseh2.repositories.ContainerRepository;
import com.example.upseh2.services.ContainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ContainerServiceImpl implements ContainerService {

    private final ContainerRepository containerRepository;


    public Page<Container> getContainers(Pageable pageable) {
        return containerRepository.findAll(pageable);
    }

    public Container addContainer(Container container) {
        return containerRepository.save(container);
    }

    public void delContainer(long id) {
        containerRepository.deleteById(id);
    }

    public Container updateContainer(long id, Container updateContainer) {
        updateContainer.setId(id);
        return containerRepository.save(updateContainer);
    }

    public Container findById(long id) {
        return containerRepository.findById(id).orElseThrow();
    }
}
