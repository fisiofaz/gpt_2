package br.com.gtp.congregation.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gtp.congregation.application.dto.request.CreateCongregationRequest;
import br.com.gtp.congregation.application.dto.request.UpdateCongregationRequest;
import br.com.gtp.congregation.application.dto.response.CongregationResponse;
import br.com.gtp.congregation.application.mapper.CongregationMapper;
import br.com.gtp.congregation.domain.entity.Congregation;
import br.com.gtp.congregation.domain.repository.CongregationRepository;
import br.com.gtp.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CongregationService {

    private final CongregationRepository repository;
    private final CongregationMapper mapper;

    public CongregationResponse create(CreateCongregationRequest request) {

        Congregation congregation = mapper.toEntity(request);

        congregation = repository.save(congregation);

        return mapper.toResponse(congregation);
    }

    @Transactional(readOnly = true)
    public CongregationResponse findById(UUID id) {

        Congregation congregation = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Congregação não encontrada."));

        return mapper.toResponse(congregation);
    }

    @Transactional(readOnly = true)
    public List<CongregationResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public CongregationResponse update(UUID id,
                                       UpdateCongregationRequest request) {

        Congregation congregation = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Congregação não encontrada."));

        mapper.updateEntity(request, congregation);

        congregation = repository.save(congregation);

        return mapper.toResponse(congregation);
    }

    public void delete(UUID id) {

        Congregation congregation = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Congregação não encontrada."));

        repository.delete(congregation);
    }

}