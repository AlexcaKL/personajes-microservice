package com.tuempresa.personajes.service.impl;

import com.tuempresa.personajes.dto.PersonajeDTO;
import com.tuempresa.personajes.entity.Personaje;
import com.tuempresa.personajes.exception.PersonajeNotFoundException;
import com.tuempresa.personajes.repository.PersonajeRepository;
import com.tuempresa.personajes.service.PersonajeService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    private final PersonajeRepository repository;

    public PersonajeServiceImpl(PersonajeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Personaje crear(PersonajeDTO dto) {
        Personaje personaje = Personaje.builder()
                .nombre(dto.getNombre())
                .identificacion(dto.getIdentificacion())
                .imagenUrl(dto.getImagenUrl())
                .rol(dto.getRol())
                .descripcion(dto.getDescripcion())
                .fechaCreacion(LocalDateTime.now())
                .build();
        return repository.save(personaje);
    }

    @Override
    @Cacheable("personajes")
    public List<Personaje> obtenerTodos(String orden) {
        List<Personaje> personajes = repository.findAll();
        if ("nombre".equalsIgnoreCase(orden)) {
            personajes.sort(Comparator.comparing(Personaje::getNombre));
        } else if ("fecha".equalsIgnoreCase(orden)) {
            personajes.sort(Comparator.comparing(Personaje::getFechaCreacion));
        }
        return personajes;
    }

    @Override
    public Personaje editar(Long id, PersonajeDTO dto) {
        Personaje personaje = repository.findById(id)
                .orElseThrow(() -> new PersonajeNotFoundException("No se encontró el personaje con ID: " + id));

        personaje.setNombre(dto.getNombre());
        personaje.setIdentificacion(dto.getIdentificacion());
        personaje.setImagenUrl(dto.getImagenUrl());
        personaje.setRol(dto.getRol());
        personaje.setDescripcion(dto.getDescripcion());
        return repository.save(personaje);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new PersonajeNotFoundException("No se encontró el personaje con ID: " + id);
        }
        repository.deleteById(id);
    }
}
