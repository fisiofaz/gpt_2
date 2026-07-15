package br.com.gtp.features.info;

import br.com.gtp.features.info.dto.ApiInfoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/api/v1/info")
    public ApiInfoResponse info() {

        return new ApiInfoResponse(
                "Gestor de Territórios e Publicações (GTP)",
                "1.0.0",
                "RUNNING"
        );

    }

}