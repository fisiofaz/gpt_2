package br.com.gtp.congregation.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gtp.congregation.domain.entity.Congregation;

public interface CongregationRepository
        extends JpaRepository<Congregation, UUID> {

    Optional<Congregation> findByCode(String code);

    boolean existsByCode(String code);

}