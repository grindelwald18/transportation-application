package com.example.upseh2.services;

import com.example.upseh2.dtos.ContainerDTO;
import com.example.upseh2.entities.Container;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ContainerService {

    Page<ContainerDTO> getContainers(Pageable pageable);

    ContainerDTO addContainer(Container container);

    void delContainer(long id);

    ContainerDTO updateContainer(long id, Container updateContainer);

    ContainerDTO findById(long id);

}
