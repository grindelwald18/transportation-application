package com.example.upseh2.services;

import com.example.upseh2.entities.Auth;

import java.util.List;

public interface AuthService {
    List<Auth> listAuthentication();
    void addAuthentication(Auth auth);
    String loginAuthentication(Auth auth);
    void deleteAuthentication(Integer id);
    void updateAuthentication(Integer id, Auth upAuth);
    Auth getAuthenticationById(Integer id);
    Auth getAuthenticationByLogin(String login);
}
