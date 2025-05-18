package com.pelis.personajes.controller;

import com.pelis.personajes.dto.PersonajeDTO;
import com.pelis.personajes.entity.Personaje;
import com.pelis.personajes.service.PersonajeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personajes")
public class PersonajeController {

    private final PersonajeService service;

    public PersonajeController(PersonajeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Personaje> crear(@RequestBody PersonajeDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<Personaje>> obtenerTodos(@RequestParam(defaultValue = "nombre") String orden) {
        return ResponseEntity.ok(service.obtenerTodos(orden));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personaje> editar(@PathVariable Long id, @RequestBody PersonajeDTO dto) {
        return ResponseEntity.ok(service.editar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ordenados/asc")
    public ResponseEntity<List<Personaje>> obtenerOrdenadosAsc() {
        return ResponseEntity.ok(service.obtenerOrdenadosPorNombreAsc());
    }

    @GetMapping("/ordenados/desc")
    public ResponseEntity<List<Personaje>> obtenerOrdenadosDesc() {
        return ResponseEntity.ok(service.obtenerOrdenadosPorNombreDesc());
    }

    @GetMapping("/ordenados/fecha-asc")
    public ResponseEntity<List<Personaje>> obtenerOrdenadosFechaAsc() {
        return ResponseEntity.ok(service.obtenerOrdenadosPorFechaAsc());
    }

    @GetMapping("/ordenados/fecha-desc")
    public ResponseEntity<List<Personaje>> obtenerOrdenadosFechaDesc() {
        return ResponseEntity.ok(service.obtenerOrdenadosPorFechaDesc());
    }
}
