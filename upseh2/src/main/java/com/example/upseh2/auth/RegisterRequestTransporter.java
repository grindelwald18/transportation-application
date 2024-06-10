package com.example.upseh2.auth;


import com.example.upseh2.entities.Auth;
import com.example.upseh2.entities.Balance;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestTransporter {
    private String companyName;
    private String logo;
    private String phoneNumber;
    private String experience;
    private String description;
    private String rating;
    private int numberEmployees;
    private Auth auth;
}