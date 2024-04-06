package com.example.upseh2.services.impl;

import com.example.upseh2.dtos.CargoDTO;
import com.example.upseh2.entities.Cargo;
import com.example.upseh2.mappers.CargoMapper;
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
    private final CargoMapper cargoMapper;

    public Page<CargoDTO> getCargos(Pageable pageable) {
        return cargoRepository.findAll(pageable)
                .map(cargoMapper::toCargoDTO);
    }
    public CargoDTO addCargo(Cargo cargo){
        cargoRepository.save(cargo);
        return cargoMapper.toCargoDTO(cargo);
    }
    public void delCargo(long id){
        cargoRepository.deleteById(id);
    }
    public CargoDTO updateCargo(long id, Cargo updateCargo){
        updateCargo.setId(id);

        return cargoMapper.toCargoDTO(cargoRepository.save(updateCargo));
    }
    public CargoDTO findCargoById(long id){
        return cargoRepository.findById(id)
                .map(cargoMapper::toCargoDTO)
                .orElseThrow();
    }
}
