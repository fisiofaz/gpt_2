package br.com.gtp.users.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.gtp.users.application.dto.request.CreateUserRequest;
import br.com.gtp.users.application.dto.request.UpdateUserRequest;
import br.com.gtp.users.application.dto.response.UserResponse;
import br.com.gtp.users.application.usecase.CreateUserUseCase;
import br.com.gtp.users.application.usecase.DeleteUserUseCase;
import br.com.gtp.users.application.usecase.FindUserByIdUseCase;
import br.com.gtp.users.application.usecase.ListUsersUseCase;
import br.com.gtp.users.application.usecase.UpdateUserUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final ListUsersUseCase listUsersUseCase;

    public UserResponse create(CreateUserRequest request) {
        return createUserUseCase.execute(request);
    }

    public UserResponse update(UUID id, UpdateUserRequest request) {
        return updateUserUseCase.execute(id, request);
    }

    public void delete(UUID id) {
        deleteUserUseCase.execute(id);
    }

    public UserResponse findById(UUID id) {
        return findUserByIdUseCase.execute(id);
    }

    public List<UserResponse> findAll() {
        return listUsersUseCase.execute();
    }
}