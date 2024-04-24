package com.example.upseh2.mappers;

import com.example.upseh2.dtos.CargoDTO;
import com.example.upseh2.entities.Cargo;
import org.mapstruct.Mapper;

@Mapper
public interface CargoMapper {
    Cargo toCargo(CargoDTO cargoDTO);

    CargoDTO toCargoDTO(Cargo cargo);
}
