package com.example.upseh2.dtos;

import com.example.upseh2.entities.Auth;
import com.example.upseh2.entities.Role;
import lombok.Data;

@Data
public class TransporterDTO {

    private long id;

    private String companyName;

    private String logo;

    private String phoneNumber;

    private Role role;

    private Auth auth;
}
