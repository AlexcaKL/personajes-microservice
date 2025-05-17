package com.tuempresa.personajes.service;

import com.tuempresa.personajes.dto.PersonajeDTO;
import com.tuempresa.personajes.entity.Personaje;
import com.tuempresa.personajes.repository.PersonajeRepository;
import com.tuempresa.personajes.service.impl.PersonajeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PersonajeServiceTest {

    private PersonajeRepository repository;
    private PersonajeService service;

    @BeforeEach
    void setup() {
        repository = mock(PersonajeRepository.class);
        service = new PersonajeServiceImpl(repository);
    }

    @Test
    void testCrearPersonaje() {
        PersonajeDTO dto = new PersonajeDTO("Goku", "ID001", "url", "Protagonista", "Saiyajin");
        Personaje personaje = Personaje.builder().nombre("Goku").build();

        when(repository.save(any(Personaje.class))).thenReturn(personaje);

        Personaje creado = service.crear(dto);
        assertEquals("Goku", creado.getNombre());
    }

    @Test
    void testObtenerTodos() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertTrue(service.obtenerTodos("nombre").isEmpty());
    }
}
