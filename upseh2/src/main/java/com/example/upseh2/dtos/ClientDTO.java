package com.example.upseh2.dtos;


import lombok.Data;

@Data
public class ClientDTO {

    private long id;

    private String surname;

    private String email;

    private String password;

    private long balanceId;

    private long roleId;
}
