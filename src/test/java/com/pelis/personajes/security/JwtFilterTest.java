package com.pelis.personajes.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class JwtFilterTest {

    @Test
    void testDoFilterWithValidToken() throws IOException, jakarta.servlet.ServletException {
        JwtUtil jwtUtil = mock(JwtUtil.class);
        JwtFilter filter = new JwtFilter(jwtUtil);

        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader("Authorization")).thenReturn("Bearer tokenValido");
        when(jwtUtil.validateToken("tokenValido")).thenReturn(true);
        when(jwtUtil.getUsernameFromToken("tokenValido")).thenReturn("admin");

        FilterChain chain = mock(FilterChain.class);
        ServletResponse response = mock(ServletResponse.class);

        filter.doFilter(request, response, chain);

        verify(chain).doFilter(request, response);
        assertNotNull(SecurityContextHolder.getContext().getAuthentication());
    }
}
