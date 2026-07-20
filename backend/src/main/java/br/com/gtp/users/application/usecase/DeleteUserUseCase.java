package br.com.gtp.users.application.usecase;

import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.gtp.shared.exception.ResourceNotFoundException;
import br.com.gtp.users.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteUserUseCase {

    private final UserRepository repository;

    public void execute(UUID id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado.");
        }

        repository.deleteById(id);

    }

}