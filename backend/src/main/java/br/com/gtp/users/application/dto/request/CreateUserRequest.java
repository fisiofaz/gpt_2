package br.com.gtp.users.application.dto.request;

import br.com.gtp.shared.enums.Role;
import br.com.gtp.shared.enums.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private String phone;

    @NotNull
    private Role role;

    @NotNull
    private UserStatus status;

    // getters e setters

}