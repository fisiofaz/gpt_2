package br.com.gtp.publishers.application.usecase;

import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.gtp.congregation.domain.entity.Congregation;
import br.com.gtp.congregation.domain.repository.CongregationRepository;
import br.com.gtp.publishers.application.dto.request.UpdatePublisherRequest;
import br.com.gtp.publishers.application.dto.response.PublisherResponse;
import br.com.gtp.publishers.application.mapper.PublisherMapper;
import br.com.gtp.publishers.domain.entity.Publisher;
import br.com.gtp.publishers.domain.repository.PublisherRepository;
import br.com.gtp.shared.constant.CongregationMessages;
import br.com.gtp.shared.constant.PublisherMessages;
import br.com.gtp.shared.exception.BusinessException;
import br.com.gtp.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdatePublisherUseCase {

    private final PublisherRepository publisherRepository;
    private final CongregationRepository congregationRepository;
    private final PublisherMapper mapper;

    @Transactional
    public PublisherResponse execute(UUID id, UpdatePublisherRequest request) {

        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(PublisherMessages.NOT_FOUND));

        Congregation congregation = congregationRepository
                .findById(request.getCongregationId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(CongregationMessages.NOT_FOUND));

        if (request.getEmail() != null
                && !Objects.equals(request.getEmail(), publisher.getEmail())
                && publisherRepository.existsByEmailAndIdNot(request.getEmail(), id)) {

            throw new BusinessException(PublisherMessages.EMAIL_ALREADY_EXISTS);
        }

        mapper.updateEntity(request, publisher);

        publisher.setCongregation(congregation);

        publisher = publisherRepository.save(publisher);

        return mapper.toResponse(publisher);
    }

}