package br.com.gtp.users.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.gtp.shared.enums.Role;
import br.com.gtp.shared.enums.UserStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private Role role;

    private UserStatus status;

    private LocalDateTime lastLogin;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;    

}