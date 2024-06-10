package com.example.upseh2.auth;


import com.example.upseh2.config.JwtService;
import com.example.upseh2.entities.*;
import com.example.upseh2.exceptions.UserAuthenticationException;
import com.example.upseh2.repositories.AuthRepository;
import com.example.upseh2.repositories.BalanceRepository;
import com.example.upseh2.repositories.ClientRepository;
import com.example.upseh2.repositories.TransporterRepository;
import org.springframework.security.core.GrantedAuthority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final SearchEngineUserRoleByUserAuthentication searchEngineUserRoleByUserAuthentication;
    private final ClientRepository clientRepository;
    private final TransporterRepository transporterRepository;
    private final AuthRepository authRepository;
    private final BalanceRepository balanceRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequestUser request) {


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
                .role(Role.CLIENT)
                .build();

        authRepository.save(userAuth);
        balanceRepository.save(balance);
        clientRepository.save(client);

        var jwtToken = jwtService.generateToken(client, client.getRole());

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user(client)
                .build();
    }

    public AuthenticationResponse registerTransporter(RegisterRequestTransporter request) {


        if (authRepository.findByLogin(request.getAuth().getLogin()) != null)
            throw new UserAuthenticationException("Поставшик с таким логином уже существует");

        var userAuth = new Auth(
                request.getAuth().getLogin(),
                passwordEncoder.encode(request.getAuth().getPassword())
        );
        var transporter = Transporter.builder()
                .companyName(request.getCompanyName())
                .logo(request.getLogo())
                .phoneNumber(request.getPhoneNumber())
                .rating(request.getRating())
                .experience(request.getExperience())
                .numberEmployees(request.getNumberEmployees())
                .description(request.getDescription())
                .authentication(userAuth)
                .role(Role.TRANSPORTER)
                .build();

        authRepository.save(userAuth);
        transporterRepository.save(transporter);

        var jwtToken = jwtService.generateToken(transporter, transporter.getRole());

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user(transporter)
                .build();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;

            // Получение роли пользователя
            String role = userDetails.getAuthorities().stream()
                    .findFirst()
                    .map(GrantedAuthority::getAuthority)
                    .orElseThrow(() -> new UserAuthenticationException("У пользователя нет ролей"));

            String jwtToken;
            if (role.equals("CLIENT")) {
                jwtToken = jwtService.generateToken(userDetails, Role.CLIENT);
            } else if (role.equals("TRANSPORTER")) {
                jwtToken = jwtService.generateToken(userDetails, Role.TRANSPORTER);
            } else {
                throw new UserAuthenticationException("Недопустимая роль пользователя: " + role);
            }

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .user(userDetails)
                    .build();
        } else {
            throw new UserAuthenticationException("Пользователь не найден");
        }
    }

}
