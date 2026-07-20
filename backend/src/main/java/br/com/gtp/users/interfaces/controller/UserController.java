package br.com.gtp.users.interfaces.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import br.com.gtp.shared.response.ApiResponse;
import br.com.gtp.shared.util.ApiPaths;
import br.com.gtp.users.application.dto.request.CreateUserRequest;
import br.com.gtp.users.application.dto.request.UpdateUserRequest;
import br.com.gtp.users.application.dto.response.UserResponse;
import br.com.gtp.users.application.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(ApiPaths.USERS)
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> create(
            @Valid @RequestBody CreateUserRequest request) {

        UserResponse response = service.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(
                        "Usuário criado com sucesso.",
                        response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> findAll() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Usuários encontrados.",
                        service.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> findById(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Usuário encontrado.",
                        service.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> update(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateUserRequest request) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Usuário atualizado com sucesso.",
                        service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @PathVariable UUID id) {

        service.delete(id);

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Usuário removido com sucesso.",
                        null));
    }
}