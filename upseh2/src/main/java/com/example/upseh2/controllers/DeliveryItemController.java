package com.example.upseh2.controllers;

import com.example.upseh2.dtos.DeliveryItemDTO;
import com.example.upseh2.services.DeliveryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveryItem")
@RequiredArgsConstructor
public class DeliveryItemController {
    private final DeliveryItemService deliveryItemService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<DeliveryItemDTO> getDelivery(Pageable pageable) {
        return deliveryItemService.getDeliveryItem(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeliveryItemDTO findById(@PathVariable long id) {
        return deliveryItemService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryItemDTO addDelivery(@RequestBody DeliveryItemDTO deliveryItemDTO) {
        return deliveryItemService.addDeliveryItem(deliveryItemDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delDelivery(@PathVariable long id) {
        deliveryItemService.delDeliveryItem(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeliveryItemDTO updateDelivery(@PathVariable long id, @RequestBody DeliveryItemDTO deliveryItemDTO) {
        return deliveryItemService.updateDeliveryItem(id, deliveryItemDTO);
    }
}
