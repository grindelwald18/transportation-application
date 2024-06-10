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

    private int distance;

    private long transportId;

    private int weight;

    private int amount;

    private int length;

    private int height;

    private int width;

    private String name;
}