package com.example.upseh2.dtos;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class DeliveryDTO {
    private long id;

    private String startPoint;

    private String finalPoint;

    private int distance;

    private ZonedDateTime sendTime;

    private int price;

    private String status;

    private long clientId;

    private long transportId;

    private long cargoId;
}
