package com.example.upseh2.auth;


import com.example.upseh2.entities.Auth;
import com.example.upseh2.entities.Balance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestUser {
    private String surname;
    private Balance balance;
    private Auth auth;
}