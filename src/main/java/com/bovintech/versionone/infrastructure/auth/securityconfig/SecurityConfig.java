package com.bovintech.versionone.infrastructure.auth.securityconfig;


import com.bovintech.versionone.infrastructure.util.ErrorResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtFilter jwtFilter;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf) -> csrf.disable())
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
                    corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
                    corsConfiguration.setAllowedHeaders(Arrays.asList("*"));

                    return corsConfiguration;
                }))
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((authorize) -> {
                            authorize.requestMatchers("/auth/login").permitAll();
                            authorize.anyRequest().authenticated();
                        }
                )
                .exceptionHandling(exceptionHandling -> {
                    exceptionHandling.authenticationEntryPoint(authenticationEntryPoint());
                    exceptionHandling.accessDeniedHandler(accessDeniedHandler());
                })
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> handleException(response, "AUTHENTICATION_ERROR", "Autenticación fallida", authException.getMessage(), HttpServletResponse.SC_UNAUTHORIZED, request.getRequestURI());
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> handleException(response, "ACCESS_DENIED", "Acceso denegado", accessDeniedException.getMessage(), HttpServletResponse.SC_FORBIDDEN, request.getRequestURI());
    }

    private void handleException(HttpServletResponse response, String code, String message, String detail, int status, String path) throws IOException {
        response.setStatus(status);
        response.setContentType("application/json");

        String jsonResponse = String.format(
                "{\"code\": \"%s\", \"message\": \"%s\", \"details\": [\"%s\"], \"path\": \"%s\", \"timestamp\": \"%s\"}",
                code,
                message,
                detail,
                path,
                LocalDateTime.now()
        );

        response.getWriter().write(jsonResponse);
    }
}