package com.example.upseh2.dtos;

import lombok.Data;

@Data
public class TransporterDTO {
    private long id;

    private String companyName;

    private String logo;

    private String phoneNumber;

    private String email;

    private String password;

    private long roleId;
}
