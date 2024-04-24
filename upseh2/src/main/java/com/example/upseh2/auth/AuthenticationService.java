package com.example.upseh2.auth;


import com.example.upseh2.config.JwtService;
import com.example.upseh2.entities.Auth;
import com.example.upseh2.entities.Balance;
import com.example.upseh2.entities.Client;
import com.example.upseh2.exceptions.UserAuthenticationException;
import com.example.upseh2.repositories.AuthRepository;
import com.example.upseh2.repositories.BalanceRepository;
import com.example.upseh2.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final SearchEngineUserRoleByUserAuthentication searchEngineUserRoleByUserAuthentication;
    private final ClientRepository clientRepository;
    private final AuthRepository authRepository;
    private final BalanceRepository balanceRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        if (authRepository.findByLogin(request.getAuth().getLogin()) != null)
            throw new UserAuthenticationException("Пользователь с таким логином уже существует");

        var userAuth = new Auth(
                request.getAuth().getLogin(),
                passwordEncoder.encode(request.getAuth().getPassword())
        );
        var balance = new Balance(request.getBalance().getBalance());
        var client = Client.builder()
                .surname(request.getSurname())
                .authentication(userAuth)
                .balance(balance)
                .build();

        authRepository.save(userAuth);
        balanceRepository.save(balance);
        clientRepository.save(client);

        var jwtToken = jwtService.generateToken(client);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user(client)
                .build();

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );

        UserDetails user = searchEngineUserRoleByUserAuthentication.searchUser(authRepository.findByLogin(request.getLogin()));
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user(user)
                .build();

    }

}
