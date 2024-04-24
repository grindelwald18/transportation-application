package com.example.upseh2.controllers;

import com.example.upseh2.dtos.DeliveryMethodDTO;
import com.example.upseh2.services.DeliveryMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveryMethod")
@RequiredArgsConstructor
public class DeliveryMethodController {
    private final DeliveryMethodService deliveryMethodService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<DeliveryMethodDTO> getDelivery(Pageable pageable) {
        return deliveryMethodService.getDeliveryMethod(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeliveryMethodDTO findById(@PathVariable long id) {
        return deliveryMethodService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryMethodDTO addDelivery(@RequestBody DeliveryMethodDTO deliveryMethodDTO) {
        return deliveryMethodService.addDeliveryMethod(deliveryMethodDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delDelivery(@PathVariable long id) {
        deliveryMethodService.delDeliveryMethod(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeliveryMethodDTO updateDelivery(@PathVariable long id, @RequestBody DeliveryMethodDTO deliveryMethodDTO) {
        return deliveryMethodService.updateDeliveryMethod(id, deliveryMethodDTO);
    }
}
