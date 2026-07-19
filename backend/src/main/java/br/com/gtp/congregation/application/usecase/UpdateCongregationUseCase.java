package br.com.gtp.congregation.application.usecase;

import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.gtp.congregation.application.dto.request.UpdateCongregationRequest;
import br.com.gtp.congregation.application.dto.response.CongregationResponse;
import br.com.gtp.congregation.application.service.CongregationService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateCongregationUseCase {

    private final CongregationService service;

    public CongregationResponse execute(UUID id,
                                        UpdateCongregationRequest request) {

        return service.update(id, request);

    }

}