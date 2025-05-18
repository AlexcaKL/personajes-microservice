package com.pelis.personajes.controller;

import com.pelis.personajes.dto.PersonajeDTO;
import com.pelis.personajes.entity.Personaje;
import com.pelis.personajes.service.PersonajeService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PersonajeControllerTest {

    @Test
    void testObtenerTodos() {
        PersonajeService service = mock(PersonajeService.class);
        PersonajeController controller = new PersonajeController(service);

        when(service.obtenerTodos("nombre")).thenReturn(List.of());
        ResponseEntity<List<Personaje>> response = controller.obtenerTodos("nombre");

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().isEmpty());
    }

    @Test
    void testCrear() {
        PersonajeService service = mock(PersonajeService.class);
        PersonajeController controller = new PersonajeController(service);
        PersonajeDTO dto = new PersonajeDTO("Sasuke", "ID003", "url", "Ninja", "Antihéroe");

        when(service.crear(dto)).thenReturn(Personaje.builder().nombre("Sasuke").build());

        ResponseEntity<Personaje> response = controller.crear(dto);
        assertEquals("Sasuke", response.getBody().getNombre());
    }
}
