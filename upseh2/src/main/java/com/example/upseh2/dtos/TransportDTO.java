package com.example.upseh2.dtos;


import lombok.Data;

@Data
public class TransportDTO {
    private long id;

    private long deliveryMethodId;

    private int capacity;

    private long speed;

    private String transportName;

    private long transporterId;
}
