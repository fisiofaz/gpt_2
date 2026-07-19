package br.com.gtp.congregation.application.dto.request;

import br.com.gtp.shared.enums.CongregationStatus;
import br.com.gtp.shared.enums.Language;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCongregationRequest {

    @NotBlank
    private String name;

    private String address;

    private String city;

    private String state;

    private String zipCode;

    private String country;

    private String circuit;

    @NotNull
    private Language language;

    @NotNull
    private CongregationStatus status;

}