package com.bovintech.versionone.infrastructure.auth.securityconfig;


import com.bovintech.versionone.application.auth.query.JwtDetailsHandler;
import com.bovintech.versionone.application.auth.query.JwtValidateHandler;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtDetailsHandler jwtDetailsHandler;
    private final JwtValidateHandler jwtValidateHandler;
    private final UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // Validar que sea un Header Authorization valido
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(authHeader == null || !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }

        // Validar que el JWT sea valido
        String jwt = authHeader.split(" ")[1].trim();

        if (!this.jwtValidateHandler.execute(jwt)){
            filterChain.doFilter(request,response);
            return;
        }


        String username = this.jwtDetailsHandler.execute(jwt);
        User user = (User) this.userDetailsService.loadUserByUsername(username);

        if (!user.isAccountNonLocked() || !user.isEnabled()) {

            filterChain.doFilter(request,response);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);


    }
}
