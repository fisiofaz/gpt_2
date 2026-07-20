package br.com.gtp.users.interfaces.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.gtp.users.application.dto.request.LoginRequest;
import br.com.gtp.users.application.dto.response.LoginResponse;
import br.com.gtp.users.application.service.AuthenticationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        return ResponseEntity.ok(
                authenticationService.authenticate(request));
    }

}