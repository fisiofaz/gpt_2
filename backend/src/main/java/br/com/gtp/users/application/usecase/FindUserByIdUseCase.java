package br.com.gtp.users.application.usecase;

import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.gtp.shared.exception.ResourceNotFoundException;
import br.com.gtp.users.application.dto.response.UserResponse;
import br.com.gtp.users.application.mapper.UserMapper;
import br.com.gtp.users.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindUserByIdUseCase {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserResponse execute(UUID id) {

        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
    }

}