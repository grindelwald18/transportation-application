package com.example.upseh2.dtos;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class BalanceDTO {
    private long id;
    private BigDecimal balance;
}
