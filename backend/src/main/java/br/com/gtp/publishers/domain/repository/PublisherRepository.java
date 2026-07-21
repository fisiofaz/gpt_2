package br.com.gtp.publishers.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gtp.publishers.domain.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, UUID> {

    Optional<Publisher> findByEmail(String email);
    
    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, UUID id);

}