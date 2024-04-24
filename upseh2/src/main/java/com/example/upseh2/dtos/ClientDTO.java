package com.example.upseh2.dtos;


import com.example.upseh2.entities.Auth;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ClientDTO {

    private long id;

    private String surname;

    private BigDecimal balance;

    private Auth auth;
}
