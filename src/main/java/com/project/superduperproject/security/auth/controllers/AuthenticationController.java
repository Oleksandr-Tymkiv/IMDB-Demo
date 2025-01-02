package com.project.superduperproject.security.auth.controllers;

import com.project.superduperproject.security.auth.services.AuthenticationService;
import com.project.superduperproject.security.auth.representation.AuthenticationRequest;
import com.project.superduperproject.security.auth.representation.AuthenticationResponse;
import com.project.superduperproject.security.auth.representation.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
//        return ResponseEntity.ok(authenticationService.register(registerRequest));
//        return authenticationService.register(registerRequest).thenApply(ResponseEntity::ok);
        return ResponseEntity.ok(authenticationService.register(registerRequest).join());
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> authentication(@RequestBody AuthenticationRequest authenticationRequest) {
//        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
//        return authenticationService.authenticate(authenticationRequest).thenApply(ResponseEntity::ok);
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest).join());
    }

}
