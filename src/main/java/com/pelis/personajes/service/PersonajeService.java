package com.tuempresa.personajes.service;

import com.tuempresa.personajes.dto.PersonajeDTO;
import com.tuempresa.personajes.entity.Personaje;

import java.util.List;

public interface PersonajeService {
    Personaje crear(PersonajeDTO dto);
    List<Personaje> obtenerTodos(String orden);
    Personaje editar(Long id, PersonajeDTO dto);
    void eliminar(Long id);
}
