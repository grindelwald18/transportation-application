package com.example.upseh2.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register/client")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterRequestUser request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/register/transporter")
    public ResponseEntity<AuthenticationResponse> registerTransporter(@RequestBody RegisterRequestTransporter request) {
        return ResponseEntity.ok(authenticationService.registerTransporter(request));
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}