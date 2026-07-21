package br.com.gtp.publishers.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.gtp.publishers.application.dto.request.CreatePublisherRequest;
import br.com.gtp.publishers.application.dto.request.UpdatePublisherRequest;
import br.com.gtp.publishers.application.dto.response.PublisherResponse;
import br.com.gtp.publishers.application.usecase.CreatePublisherUseCase;
import br.com.gtp.publishers.application.usecase.DeletePublisherUseCase;
import br.com.gtp.publishers.application.usecase.FindPublisherByIdUseCase;
import br.com.gtp.publishers.application.usecase.ListPublishersUseCase;
import br.com.gtp.publishers.application.usecase.UpdatePublisherUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final CreatePublisherUseCase createPublisherUseCase;
    private final UpdatePublisherUseCase updatePublisherUseCase;
    private final DeletePublisherUseCase deletePublisherUseCase;
    private final FindPublisherByIdUseCase findPublisherByIdUseCase;
    private final ListPublishersUseCase listPublishersUseCase;

    public PublisherResponse create(CreatePublisherRequest request) {
        return createPublisherUseCase.execute(request);
    }

    public PublisherResponse update(UUID id, UpdatePublisherRequest request) {
        return updatePublisherUseCase.execute(id, request);
    }

    public void delete(UUID id) {
        deletePublisherUseCase.execute(id);
    }

    public PublisherResponse findById(UUID id) {
        return findPublisherByIdUseCase.execute(id);
    }

    public List<PublisherResponse> findAll() {
        return listPublishersUseCase.execute();
    }

}