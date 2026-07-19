package br.com.gtp.shared.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiError {

    private LocalDateTime timestamp;

    private Integer status;

    private String error;

    private String message;

    private List<String> details;

}