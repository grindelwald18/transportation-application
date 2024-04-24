package com.example.upseh2.controllers;

import com.example.upseh2.dtos.CargoDTO;
import com.example.upseh2.services.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cargo")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService cargoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<CargoDTO> getCargos(Pageable pageable) {
        return cargoService.getCargos(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CargoDTO getCargoById(@PathVariable long id) {
        return cargoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CargoDTO addCargo(@RequestBody CargoDTO cargoDTO) {
        return cargoService.addCargo(cargoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delCargo(@PathVariable long id) {
        cargoService.delCargo(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CargoDTO updateCargo(@PathVariable long id, @RequestBody CargoDTO cargoDTO) {
        return cargoService.updateCargo(id, cargoDTO);
    }
}
