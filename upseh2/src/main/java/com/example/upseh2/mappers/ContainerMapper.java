package com.example.upseh2.mappers;

import com.example.upseh2.dtos.ContainerDTO;
import com.example.upseh2.entities.Container;
import org.mapstruct.Mapper;

@Mapper
public interface ContainerMapper {
    Container toContainer(ContainerDTO containerDTO);
    ContainerDTO toContainerDTO(Container container);
}
