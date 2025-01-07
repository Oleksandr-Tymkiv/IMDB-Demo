package com.project.imdbdemo.app.api.services.authServices;

import com.project.imdbdemo.app.api.representation.authRepresentation.AuthenticationRequest;
import com.project.imdbdemo.app.api.representation.authRepresentation.AuthenticationResponse;
import com.project.imdbdemo.app.api.representation.authRepresentation.RegisterRequest;
import com.project.imdbdemo.security.config.security.JwtService;
import com.project.imdbdemo.app.models.user.User;
import com.project.imdbdemo.app.repository.user.UserRepository;
import com.project.imdbdemo.app.repository.user.roles.Role;
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

    public AuthenticationResponse register(RegisterRequest registerRequest){
        if(userRepository.findByEmail(registerRequest.getEmail()).isPresent()){
            throw new IllegalStateException("Phone has taken");
        }
        var user = User.builder()
                .name(registerRequest.getName())
                .dateOfBirth(registerRequest.getDateOfBirth())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
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
