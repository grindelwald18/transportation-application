package com.example.upseh2.controllers;

import com.example.upseh2.dtos.ContainerDTO;
import com.example.upseh2.entities.Container;
import com.example.upseh2.services.ContainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/container")
@RequiredArgsConstructor
public class ContainerController {
    private final ContainerService containerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Container> getContainers(Pageable pageable) {
        return containerService.getContainers(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Container findById(@PathVariable long id) {
        return containerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Container addContainer(@RequestBody ContainerDTO containerDTO) {
        return containerService.addContainer(containerDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delContainer(@PathVariable long id) {
        containerService.delContainer(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Container updateContainer(@PathVariable long id, @RequestBody ContainerDTO containerDTO) {
        return containerService.updateContainer(id, containerDTO);
    }
}
