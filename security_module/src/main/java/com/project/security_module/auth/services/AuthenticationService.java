package com.project.security_module.auth.services;

import com.project.security_module.auth.representation.AuthenticationRequest;
import com.project.security_module.auth.representation.AuthenticationResponse;
import com.project.security_module.auth.representation.RegisterRequest;
import com.project.security_module.config.security.JwtService;
import com.project.security_module.users.models.User;
import com.project.security_module.users.repositories.UserRepository;
import com.project.security_module.users.roles.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Async("AsyncTask")
    public CompletableFuture<AuthenticationResponse> register(RegisterRequest registerRequest) {
        return userRepository.findByEmail(registerRequest.getEmail())
                .thenApply(userR -> {
                    if (userR.isPresent()) {
                        throw new IllegalStateException("User already exists");
                    }
                    var user = User
                            .builder()
                            .name(registerRequest.getName())
                            .password(passwordEncoder.encode(registerRequest.getPassword()))
                            .email(registerRequest.getEmail())
                            .dateOfBirth(registerRequest.getDateOfBirth())
                            .role(Role.USER)
                            .build();

                    userRepository.save(user);
                    var jwt = jwtService.generatorJwt(user);
                    return AuthenticationResponse.builder().token(jwt).build();
                });
    }

    @Async("AsyncTask")
    public CompletableFuture<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        UserDetails user = (UserDetails) authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        ).getPrincipal();

        var jwt = jwtService.generatorJwt(user);
        return CompletableFuture.completedFuture(AuthenticationResponse
                .builder()
                .token(jwt)
                .build());
    }
}
