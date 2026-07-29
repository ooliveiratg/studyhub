package br.com.studyHub.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final SecurityFilter securityFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http
                .csrf(c -> c.disable())
                .authorizeHttpRequests((authorize) -> {
                            authorize
                                    .requestMatchers("/auth")
                                    .permitAll()
                                    .requestMatchers("/auth/students")
                                    .permitAll();
                            authorize.anyRequest().authenticated();
                        }

                );
        http.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder encoderPassword() {
        return new BCryptPasswordEncoder();
    }
}
