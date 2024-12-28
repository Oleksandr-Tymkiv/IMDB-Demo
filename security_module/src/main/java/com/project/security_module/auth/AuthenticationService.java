package com.project.security_module.auth;

import com.project.security_module.auth.AuthenticationResponse;
import com.project.security_module.config.JwtService;
import com.project.security_module.users.models.User;
import com.project.security_module.users.repositories.UserRepository;
import com.project.security_module.users.roles.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        if(userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new IllegalStateException("Email has taken");
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
        return AuthenticationResponse
                .builder()
                .token(jwt)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        UserDetails user = (UserDetails) authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        ).getPrincipal();

        var jwt = jwtService.generatorJwt(user);
        return AuthenticationResponse
                .builder()
                .token(jwt)
                .build();
    }
}
