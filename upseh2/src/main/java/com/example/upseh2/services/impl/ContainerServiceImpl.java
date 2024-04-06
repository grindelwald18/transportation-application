package com.example.upseh2.services.impl;

import com.example.upseh2.dtos.ContainerDTO;
import com.example.upseh2.entities.Container;
import com.example.upseh2.mappers.ContainerMapper;
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
    private final ContainerMapper containerMapper;

    public Page<ContainerDTO> getContainers(Pageable pageable) {
        return containerRepository.findAll(pageable)
                .map(containerMapper::toContainerDTO);
    }

    public ContainerDTO addContainer(Container container) {
        return containerMapper.toContainerDTO(containerRepository.save(container));
    }

    public void delContainer(long id) {
        containerRepository.deleteById(id);
    }

    public ContainerDTO updateContainer(long id, Container updateContainer) {
        updateContainer.setId(id);
        return containerMapper.toContainerDTO(containerRepository.save(updateContainer));
    }

    public ContainerDTO findById(long id) {
        return containerRepository.findById(id)
                .map(containerMapper::toContainerDTO)
                .orElseThrow();
    }
}
