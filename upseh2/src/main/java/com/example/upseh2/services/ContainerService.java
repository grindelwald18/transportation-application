package com.example.upseh2.services;

import com.example.upseh2.entities.Container;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ContainerService {

    Page<Container> getContainers(Pageable pageable);

    Container addContainer(Container container);

    void delContainer(long id);

    Container updateContainer(long id, Container updateContainer);

    Container findById(long id);

}
