package com.example.upseh2.auth;

import com.example.upseh2.entities.Auth;

import java.util.Optional;

public interface SearchEngineUserByUserAuthentication<T> {
    Optional<T> findUserByUserAuthentication(Auth userAuth);
}