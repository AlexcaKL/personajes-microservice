package com.pelis.personajes.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JwtUtilTest {

    @Test
    void testGenerateAndValidateToken() {
        JwtUtil util = new JwtUtil();
        String token = util.generateToken("admin");

        assertTrue(util.validateToken(token));
        assertEquals("admin", util.getUsernameFromToken(token));
    }
}
