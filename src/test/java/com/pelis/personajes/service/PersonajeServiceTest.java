package com.pelis.personajes.service;

import com.pelis.personajes.dto.PersonajeDTO;
import com.pelis.personajes.entity.Personaje;
import com.pelis.personajes.repository.PersonajeRepository;
import com.pelis.personajes.service.impl.PersonajeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PersonajeServiceTest {

    private PersonajeRepository repository;
    private PersonajeService service;

    @BeforeEach
    void setUp() {
        repository = mock(PersonajeRepository.class);
        service = new PersonajeServiceImpl(repository);
    }

    @Test
    void testCrearPersonaje() {
        PersonajeDTO dto = new PersonajeDTO("Naruto", "ID002", "url", "Ninja", "Héroe ninja");
        Personaje personajeMock = Personaje.builder().nombre("Naruto").build();

        when(repository.save(any(Personaje.class))).thenReturn(personajeMock);

        Personaje result = service.crear(dto);
        assertEquals("Naruto", result.getNombre());
    }

    @Test
    void testObtenerTodos() {
        when(repository.findAll()).thenReturn(new java.util.ArrayList<>());
        assertTrue(service.obtenerTodos("nombre").isEmpty());
    }
}
