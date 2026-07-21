package br.com.gtp.publishers.application.dto.response;

import java.time.LocalDate;
import java.util.UUID;

import br.com.gtp.shared.enums.Gender;
import br.com.gtp.shared.enums.PublisherStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublisherResponse {

    private UUID id;

    private String firstName;

    private String lastName;

    private Gender gender;

    private LocalDate birthDate;

    private LocalDate baptismDate;

    private LocalDate joinDate;

    private String phone;

    private String email;

    private String address;

    private PublisherStatus status;

    private UUID congregationId;

}