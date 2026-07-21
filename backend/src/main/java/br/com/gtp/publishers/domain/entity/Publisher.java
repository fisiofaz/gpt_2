package br.com.gtp.publishers.domain.entity;

import java.time.LocalDate;

import br.com.gtp.congregation.domain.entity.Congregation;
import br.com.gtp.shared.entity.BaseEntity;
import br.com.gtp.shared.enums.Gender;
import br.com.gtp.shared.enums.PublisherStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "publishers")
public class Publisher extends BaseEntity {

    @Column(nullable = false, length = 80)
    private String firstName;

    @Column(nullable = false, length = 80)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(length = 20)
    private String phone;

    @Column(length = 120)
    private String email;

    @Column(length = 255)
    private String address;

    @Column(name = "join_date")
    private LocalDate joinDate;

    @Column(name = "baptism_date")
    private LocalDate baptismDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PublisherStatus status = PublisherStatus.ACTIVE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "congregation_id", nullable = false)
    private Congregation congregation;

}