package br.com.gtp.congregation.application.usecase;

import org.springframework.stereotype.Component;

import br.com.gtp.congregation.application.dto.request.CreateCongregationRequest;
import br.com.gtp.congregation.application.dto.response.CongregationResponse;
import br.com.gtp.congregation.application.service.CongregationService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateCongregationUseCase {

    private final CongregationService service;

    public CongregationResponse execute(CreateCongregationRequest request) {
        return service.create(request);
    }

}