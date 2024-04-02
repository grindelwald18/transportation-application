package com.example.upseh2.services;

import com.example.upseh2.entities.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CargoService {

    Page<Cargo> getCargos(Pageable pageable);

    Cargo addCargo(Cargo cargo);

    void delCargo(long id);

    Cargo updateCargo(long id, Cargo updateCargo);

    Cargo findCargoById(long id);

}
