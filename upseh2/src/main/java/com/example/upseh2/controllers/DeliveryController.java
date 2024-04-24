package com.example.upseh2.controllers;

import com.example.upseh2.dtos.DeliveryDTO;
import com.example.upseh2.entities.Delivery;
import com.example.upseh2.services.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor

public class DeliveryController {
    
    private final DeliveryService deliveryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Delivery> getDelivery(Pageable pageable) {
        return deliveryService.getDelivery(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Delivery findById(@PathVariable long id) {
        return deliveryService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery addDelivery(@RequestBody DeliveryDTO deliveryDTO) {
        return deliveryService.addDelivery(deliveryDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delDelivery(@PathVariable long id) {
        deliveryService.delDelivery(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Delivery updateDelivery(@PathVariable long id, @RequestBody DeliveryDTO deliveryDTO) {
        return deliveryService.updateDelivery(id, deliveryDTO);
    }
}
