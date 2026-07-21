package br.com.gtp.publishers.application.dto.request;

import java.time.LocalDate;
import java.util.UUID;

import br.com.gtp.shared.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePublisherRequest {

	@NotBlank
    private String firstName;

	@NotBlank
    private String lastName;

    @NotNull
    private Gender gender;

    private LocalDate birthDate;

    private LocalDate baptismDate;

    private LocalDate joinDate;

    private String phone;

    @Email
    private String email;

    private String address;

    
    private UUID congregationId;

}