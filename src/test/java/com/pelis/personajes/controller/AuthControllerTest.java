package com.pelis.personajes.controller;

import com.pelis.personajes.security.JwtUtil;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AuthControllerTest {

    @Test
    void testLoginCorrecto() {
        JwtUtil jwtUtil = new JwtUtil();
        AuthController controller = new AuthController(jwtUtil);

        Map<String, String> credentials = Map.of("username", "admin", "password", "1234");
        Map<String, String> response = controller.login(credentials);


        assertNotNull(response);
        assertTrue(response.get("token").startsWith("ey"));

    }
}
