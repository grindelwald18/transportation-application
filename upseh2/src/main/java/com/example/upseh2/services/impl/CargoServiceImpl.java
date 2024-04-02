package com.example.upseh2.services.impl;

import com.example.upseh2.entities.Cargo;
import com.example.upseh2.repositories.CargoRepository;
import com.example.upseh2.services.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CargoServiceImpl implements CargoService {
    private final CargoRepository cargoRepository;

    public Page<Cargo> getCargos(Pageable pageable) {
        return cargoRepository.findAll(pageable);
    }
    public Cargo addCargo(Cargo cargo){
        cargoRepository.save(cargo);
        return cargo;
    }
    public void delCargo(long id){
        cargoRepository.deleteById(id);
    }
    public Cargo updateCargo(long id, Cargo updateCargo){
        updateCargo.setId(id);
        cargoRepository.save(updateCargo);
        return updateCargo;
    }
    public Cargo findCargoById(long id){
        return cargoRepository.findById(id).orElseThrow();
    }
}
