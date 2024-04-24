package com.example.upseh2.controllers;

import com.example.upseh2.dtos.TransporterDTO;
import com.example.upseh2.services.TransporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transporter")
@RequiredArgsConstructor
public class TransporterController {
    private final TransporterService transporterService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<TransporterDTO> getAllTransporters(Pageable pageable){
        return transporterService.getAllTransporters(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransporterDTO getTransporterById(@PathVariable long id){
        return transporterService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransporterDTO addTransporter(@RequestBody TransporterDTO TransporterDTO) {
        return transporterService.addTransporter(TransporterDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delTransporter(@PathVariable long id) {
        transporterService.delTransporter(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransporterDTO updateTransporter(@PathVariable long id, @RequestBody TransporterDTO TransporterDTO) {
        return transporterService.updateTransporter(id, TransporterDTO);
    }
}
