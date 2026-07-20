package br.com.gtp.users.application.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.gtp.users.application.dto.response.UserResponse;
import br.com.gtp.users.application.mapper.UserMapper;
import br.com.gtp.users.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ListUsersUseCase {

    private final UserRepository repository;
    private final UserMapper mapper;

    public List<UserResponse> execute() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

}