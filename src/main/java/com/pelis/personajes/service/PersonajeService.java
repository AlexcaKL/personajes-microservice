package com.pelis.personajes.service;

import com.pelis.personajes.dto.PersonajeDTO;
import com.pelis.personajes.entity.Personaje;

import java.util.List;

public interface PersonajeService {
    Personaje crear(PersonajeDTO dto);
    List<Personaje> obtenerTodos(String orden);
    Personaje editar(Long id, PersonajeDTO dto);
    void eliminar(Long id);
    List<Personaje> obtenerOrdenadosPorNombreAsc();
    List<Personaje> obtenerOrdenadosPorNombreDesc();
    List<Personaje> obtenerOrdenadosPorFechaAsc();
    List<Personaje> obtenerOrdenadosPorFechaDesc();

}
