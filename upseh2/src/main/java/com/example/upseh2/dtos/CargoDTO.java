package com.example.upseh2.dtos;

import lombok.Data;

@Data
public class CargoDTO {
    private long id;
    private int length;
    private int width;
    private int height;
    private long weight;
    private String name;
    private boolean nature;
}
