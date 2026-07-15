package br.com.gtp.features.info.dto;

public record ApiInfoResponse(
        String application,
        String version,
        String status
) {
}