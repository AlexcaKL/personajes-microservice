package com.pelis.personajes.repository;

import com.pelis.personajes.entity.Personaje;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
      List<Personaje> findAllByOrderByNombreAsc();
      List<Personaje> findAllByOrderByNombreDesc();
      List<Personaje> findAllByOrderByFechaCreacionAsc();
      List<Personaje> findAllByOrderByFechaCreacionDesc();

}
