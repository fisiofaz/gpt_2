package br.com.gtp.users.domain.entity;

import java.time.LocalDateTime;

import br.com.gtp.congregation.domain.entity.Congregation;
import br.com.gtp.shared.entity.BaseEntity;
import br.com.gtp.shared.enums.Role;
import br.com.gtp.shared.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 20)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private UserStatus status;

    private LocalDateTime lastLogin;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "congregation_id")
    private Congregation congregation;

}