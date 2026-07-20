package br.com.gtp.users.application.usecase;

import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.gtp.shared.exception.ResourceNotFoundException;
import br.com.gtp.users.application.dto.request.UpdateUserRequest;
import br.com.gtp.users.application.dto.response.UserResponse;
import br.com.gtp.users.application.mapper.UserMapper;
import br.com.gtp.users.domain.entity.User;
import br.com.gtp.users.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateUserUseCase {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserResponse execute(UUID id, UpdateUserRequest request) {

        User entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));

        mapper.updateEntity(request, entity);

        entity = repository.save(entity);

        return mapper.toResponse(entity);
    }

}