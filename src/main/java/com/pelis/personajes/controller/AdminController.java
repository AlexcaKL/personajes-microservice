package com.pelis.personajes.controller;

import com.pelis.personajes.service.CacheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final CacheService cacheService;

    public AdminController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping("/limpiar-cache")
    public ResponseEntity<String> limpiarCache() {
        cacheService.limpiarCachePersonajes();
        return ResponseEntity.ok("Caché de personajes limpiado con éxito.");
    }
}
