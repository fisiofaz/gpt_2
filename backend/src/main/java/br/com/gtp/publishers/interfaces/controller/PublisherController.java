package br.com.gtp.publishers.interfaces.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.gtp.publishers.application.dto.request.CreatePublisherRequest;
import br.com.gtp.publishers.application.dto.request.UpdatePublisherRequest;
import br.com.gtp.publishers.application.dto.response.PublisherResponse;
import br.com.gtp.publishers.application.service.PublisherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/publishers")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PublisherResponse create(
            @Valid @RequestBody CreatePublisherRequest request) {

        return service.create(request);
    }

    @GetMapping
    public List<PublisherResponse> findAll() {

        return service.findAll();
    }

    @GetMapping("/{id}")
    public PublisherResponse findById(
            @PathVariable UUID id) {

        return service.findById(id);
    }

    @PutMapping("/{id}")
    public PublisherResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody UpdatePublisherRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID id) {

        service.delete(id);
    }

}