package com.example.upseh2.services;

import com.example.upseh2.dtos.CargoDTO;
import com.example.upseh2.entities.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CargoService {

    Page<CargoDTO> getCargos(Pageable pageable);

    CargoDTO addCargo(CargoDTO cargoDTO);

    void delCargo(long id);

    CargoDTO updateCargo(long id, CargoDTO updateCargoDTO);

    CargoDTO findById(long id);

}
