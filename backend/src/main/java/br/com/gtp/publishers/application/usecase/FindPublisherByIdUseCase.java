package br.com.gtp.publishers.application.usecase;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.gtp.publishers.application.dto.response.PublisherResponse;
import br.com.gtp.publishers.application.mapper.PublisherMapper;
import br.com.gtp.publishers.domain.entity.Publisher;
import br.com.gtp.publishers.domain.repository.PublisherRepository;
import br.com.gtp.shared.constant.PublisherMessages;
import br.com.gtp.shared.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindPublisherByIdUseCase {

    private final PublisherRepository repository;
    private final PublisherMapper mapper;

    @Transactional(readOnly = true)
    public PublisherResponse execute(UUID id) {

        Publisher publisher = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(PublisherMessages.NOT_FOUND));

        return mapper.toResponse(publisher);
    }

}