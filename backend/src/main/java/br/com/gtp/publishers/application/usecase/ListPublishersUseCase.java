package br.com.gtp.publishers.application.usecase;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.gtp.publishers.application.dto.response.PublisherResponse;
import br.com.gtp.publishers.application.mapper.PublisherMapper;
import br.com.gtp.publishers.domain.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ListPublishersUseCase {

    private final PublisherRepository repository;
    private final PublisherMapper mapper;

    @Transactional(readOnly = true)
    public List<PublisherResponse> execute() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

}