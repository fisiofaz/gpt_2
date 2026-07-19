package br.com.gtp.shared.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {

        return new OpenAPI()

                .info(

                        new Info()

                                .title("Gestor de Territórios e Publicações")

                                .version("1.0")

                                .description("""
                                        API oficial do GTP.

                                        Sistema de gerenciamento de:

                                        • Congregações
                                        • Publicadores
                                        • Territórios
                                        • Designações
                                        • Publicações
                                        • Relatórios
                                        """)

                                .contact(

                                        new Contact()
                                                .name("Projeto GTP")
                                                .email("contato@gtp.com.br")
                                )

                                .license(

                                        new License()
                                                .name("MIT")
                                )
                )

                .externalDocs(

                        new ExternalDocumentation()
                                .description("Documentação do Projeto")
                                .url("https://github.com/fisiofaz/GTP")
                );
    }

}