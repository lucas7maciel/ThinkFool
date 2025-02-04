package com.lucas.think_fool.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.think_fool.config.auth.TokenProvider;
import com.lucas.think_fool.dtos.JwtDto;
import com.lucas.think_fool.dtos.SignInDto;
import com.lucas.think_fool.dtos.SignUpDto;
import com.lucas.think_fool.thinker.Thinker;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService service;

    @Autowired
    private TokenProvider tokenService;

    // Fazer validação do DTO e adicionar @Valid
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpDto data) throws Exception {
        service.signUp(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Fazer validação do DTO e adicionar @Valid
    @PostMapping("/signin")
    public ResponseEntity<JwtDto> signIn(@RequestBody @Valid SignInDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var authUser = authenticationManager.authenticate(usernamePassword);
        var accessToken = tokenService.generateAccessToken((Thinker) authUser.getPrincipal());

        return ResponseEntity.ok(new JwtDto(accessToken));
    }
}
