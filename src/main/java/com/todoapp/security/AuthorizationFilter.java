package com.todoapp.security;

import static java.util.List.of;
import static java.util.Optional.ofNullable;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todoapp.app.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationFilter extends BasicAuthenticationFilter {

    public AuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtsTokenUtils jwtsTokenUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain) throws IOException, ServletException {

        // Get authorization header and validate
        final String header = req.getHeader(HttpHeaders.AUTHORIZATION);
        if (header.isEmpty() || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        // Get jwt token and validate
        final String token = header.split(" ")[1].trim();
        if (!jwtsTokenUtils.validate(token)) {
            chain.doFilter(req, res);
            return;
        }

        UserDetails userDetails = userRepo
                .findByUsername(jwtsTokenUtils.getUsername(token))
                .orElse(null);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null,
                ofNullable(userDetails).map(UserDetails::getAuthorities).orElse(of()));

        authentication
                .setDetails(new WebAuthenticationDetailsSource().buildDetails(req));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }
}
