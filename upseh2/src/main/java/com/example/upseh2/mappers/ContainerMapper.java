package com.example.upseh2.mappers;

import com.example.upseh2.dtos.ContainerDTO;
import com.example.upseh2.entities.Container;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ContainerMapper {

    @Mapping(target = "deliveryItems", source = "deliveryItems" ) // указываем имя свойства deliveryItems
    Container toContainer(ContainerDTO containerDTO);

    @Mapping(target = "deliveryItems", source = "deliveryItems" ) // указываем имя свойства deliveryItems
    ContainerDTO toContainerDTO(Container container);
}

