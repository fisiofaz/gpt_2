package br.com.gtp.congregation.application.dto.response;

import java.util.UUID;

import br.com.gtp.shared.enums.CongregationStatus;
import br.com.gtp.shared.enums.Language;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CongregationResponse {

    private UUID id;

    private String code;

    private String name;

    private String address;

    private String city;

    private String state;

    private String zipCode;

    private String country;

    private String circuit;

    private Language language;

    private CongregationStatus status;

}