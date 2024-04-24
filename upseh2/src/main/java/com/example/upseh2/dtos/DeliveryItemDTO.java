package com.example.upseh2.dtos;

import lombok.Data;

@Data
public class DeliveryItemDTO {
    private long id;
    private long cargoId;
    private int amount;
}
