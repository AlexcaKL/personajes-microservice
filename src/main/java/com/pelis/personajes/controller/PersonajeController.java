package com.tuempresa.personajes.controller;

import com.tuempresa.personajes.dto.PersonajeDTO;
import com.tuempresa.personajes.entity.Personaje;
import com.tuempresa.personajes.service.PersonajeService;
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
}
