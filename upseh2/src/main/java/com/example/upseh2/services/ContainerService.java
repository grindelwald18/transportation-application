package com.example.upseh2.services;

import com.example.upseh2.dtos.ContainerDTO;
import com.example.upseh2.entities.Container;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ContainerService {

    Page<Container> getContainers(Pageable pageable);

    Container addContainer(ContainerDTO containerDTO);

    void delContainer(long id);

    Container updateContainer(long id, ContainerDTO updateContainerDTO);

    Container findById(long id);

}
