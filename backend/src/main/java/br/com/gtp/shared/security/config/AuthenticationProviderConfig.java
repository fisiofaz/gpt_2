package br.com.gtp.shared.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.gtp.shared.security.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AuthenticationProviderConfig {

    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);

        return provider;
    }

}