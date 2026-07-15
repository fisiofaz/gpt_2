package br.com.gtp.features.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/api/v1/health")
    public Map<String, Object> health() {

        return Map.of(
                "status", "UP",
                "timestamp", LocalDateTime.now()
        );

    }

}