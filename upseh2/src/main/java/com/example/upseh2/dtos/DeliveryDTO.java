package com.example.upseh2.dtos;

import com.example.upseh2.entities.Cargo;
import com.example.upseh2.entities.Container;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class DeliveryDTO {
    private long id;

    private String startPoint;

    private String finalPoint;

    private long distance;

    private ZonedDateTime sendTime;

    private int travelTime;

    private BigDecimal price;

    private String status;

    private long clientId;

    private long transportId;

    private List<ContainerIdDTO> container;
}