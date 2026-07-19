package br.com.gtp.congregation.application.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.gtp.congregation.application.dto.response.CongregationResponse;
import br.com.gtp.congregation.application.service.CongregationService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindAllCongregationsUseCase {

    private final CongregationService service;

    public List<CongregationResponse> execute() {
        return service.findAll();
    }

}