package br.com.gtp.users.application.usecase;

import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.gtp.shared.exception.BusinessException;
import br.com.gtp.users.application.dto.request.CreateUserRequest;
import br.com.gtp.users.application.dto.response.UserResponse;
import br.com.gtp.users.application.mapper.UserMapper;
import br.com.gtp.users.domain.entity.User;
import br.com.gtp.users.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponse execute(CreateUserRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new BusinessException("E-mail já cadastrado.");
        }

        User entity = mapper.toEntity(request);

        entity.setPassword(passwordEncoder.encode(request.getPassword()));

        entity = repository.save(entity);

        return mapper.toResponse(entity);
    }

}