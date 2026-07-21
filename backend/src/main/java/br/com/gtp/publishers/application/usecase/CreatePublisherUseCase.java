package br.com.gtp.publishers.application.usecase;

import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.gtp.shared.constant.CongregationMessages;
import br.com.gtp.shared.constant.PublisherMessages;
import br.com.gtp.congregation.domain.entity.Congregation;
import br.com.gtp.congregation.domain.repository.CongregationRepository;
import br.com.gtp.publishers.application.dto.request.CreatePublisherRequest;
import br.com.gtp.publishers.application.dto.response.PublisherResponse;
import br.com.gtp.publishers.application.mapper.PublisherMapper;
import br.com.gtp.publishers.domain.entity.Publisher;
import br.com.gtp.publishers.domain.repository.PublisherRepository;
import br.com.gtp.shared.enums.PublisherStatus;
import br.com.gtp.shared.exception.BusinessException;
import br.com.gtp.shared.exception.ResourceNotFoundException;
import br.com.gtp.users.domain.entity.User;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreatePublisherUseCase {

    private final PublisherRepository publisherRepository;
    private final CongregationRepository congregationRepository;
    private final PublisherMapper mapper;

    @Transactional
    public PublisherResponse execute(CreatePublisherRequest request) {

        if (request.getEmail() != null
                && publisherRepository.existsByEmail(request.getEmail())) {
            throw new BusinessException(PublisherMessages.EMAIL_ALREADY_EXISTS);
        }

        // 1. Resolve qual ID de congregação será usado
        UUID congregationId = resolveCongregationId(request.getCongregationId());

        // 2. Busca a congregação no banco de dados
        Congregation congregation = congregationRepository
                .findById(congregationId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(CongregationMessages.NOT_FOUND));

        Publisher publisher = mapper.toEntity(request);
        publisher.setCongregation(congregation);
        publisher.setStatus(PublisherStatus.ACTIVE);

        publisher = publisherRepository.save(publisher);

        return mapper.toResponse(publisher);
    }

    private UUID resolveCongregationId(UUID targetCongregationId) {
        // Se foi enviado no JSON, usa o enviado
        if (targetCongregationId != null) {
            return targetCongregationId;
        }

        // Se veio nulo no JSON, descobre a congregação do usuário logado no Spring Security
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.getPrincipal() instanceof User currentUser) {
            if (currentUser.getCongregation() != null) {
                return currentUser.getCongregation().getId();
            }
            throw new BusinessException("O usuário logado não possui uma congregação associada.");
        }

        throw new BusinessException("Não foi possível identificar o usuário autenticado.");
    }
}