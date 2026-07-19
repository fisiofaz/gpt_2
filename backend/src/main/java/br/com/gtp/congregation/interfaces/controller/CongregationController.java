package br.com.gtp.congregation.interfaces.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.gtp.congregation.application.dto.request.CreateCongregationRequest;
import br.com.gtp.congregation.application.dto.request.UpdateCongregationRequest;
import br.com.gtp.congregation.application.dto.response.CongregationResponse;
import br.com.gtp.congregation.application.usecase.CreateCongregationUseCase;
import br.com.gtp.congregation.application.usecase.DeleteCongregationUseCase;
import br.com.gtp.congregation.application.usecase.FindAllCongregationsUseCase;
import br.com.gtp.congregation.application.usecase.FindCongregationByIdUseCase;
import br.com.gtp.congregation.application.usecase.UpdateCongregationUseCase;
import br.com.gtp.shared.response.ApiResponse;
import br.com.gtp.shared.util.ApiPaths;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(ApiPaths.CONGREGATIONS)
@RequiredArgsConstructor
public class CongregationController {

    private final CreateCongregationUseCase createUseCase;
    private final FindAllCongregationsUseCase findAllUseCase;
    private final FindCongregationByIdUseCase findByIdUseCase;
    private final UpdateCongregationUseCase updateUseCase;
    private final DeleteCongregationUseCase deleteUseCase;

    @PostMapping
    public ResponseEntity<ApiResponse<CongregationResponse>> create(
            @Valid @RequestBody CreateCongregationRequest request) {

        CongregationResponse response = createUseCase.execute(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Congregação criada com sucesso.", response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CongregationResponse>>> findAll() {

        List<CongregationResponse> response = findAllUseCase.execute();

        return ResponseEntity.ok(
                ApiResponse.success(response)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CongregationResponse>> findById(
            @PathVariable UUID id) {

        CongregationResponse response = findByIdUseCase.execute(id);

        return ResponseEntity.ok(
                ApiResponse.success(response)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CongregationResponse>> update(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateCongregationRequest request) {

        CongregationResponse response = updateUseCase.execute(id, request);

        return ResponseEntity.ok(
                ApiResponse.success("Congregação atualizada com sucesso.", response)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @PathVariable UUID id) {

        deleteUseCase.execute(id);

        return ResponseEntity.ok(
                ApiResponse.success("Congregação removida com sucesso.", null)
        );
    }

}