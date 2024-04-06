package com.example.upseh2.dtos;


import lombok.Data;

@Data
public class ContainerDTO {

    private long id;

    private int containerLength;

    private int containerWidth;

    private int containerHeight;

    private long deliveryMethodId;

    private long cargoId;

    private int cargoAmount;
}
