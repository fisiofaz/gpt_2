package br.com.gtp.publishers.application.usecase;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.gtp.publishers.domain.entity.Publisher;
import br.com.gtp.publishers.domain.repository.PublisherRepository;
import br.com.gtp.shared.constant.PublisherMessages;
import br.com.gtp.shared.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeletePublisherUseCase {

    private final PublisherRepository repository;

    @Transactional
    public void execute(UUID id) {

        Publisher publisher = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(PublisherMessages.NOT_FOUND));

        /*
         * Regra para as próximas Sprints:
         *
         * - Não permitir excluir se possuir territórios.
         * - Não permitir excluir se possuir publicações emprestadas.
         * - Não permitir excluir se possuir histórico de designações.
         *
         * Neste momento a exclusão é permitida.
         */

        repository.delete(publisher);
    }

}