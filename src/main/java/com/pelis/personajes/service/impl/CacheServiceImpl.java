package com.pelis.personajes.service.impl;

import com.pelis.personajes.service.CacheService;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    private final CacheManager cacheManager;

    public CacheServiceImpl(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public void limpiarCachePersonajes() {
        if (cacheManager.getCache("personajes") != null) {
            cacheManager.getCache("personajes").clear();
        }
        if (cacheManager.getCache("personajesNombreAsc") != null) {
            cacheManager.getCache("personajesNombreAsc").clear();
        }
        if (cacheManager.getCache("personajesNombreDesc") != null) {
            cacheManager.getCache("personajesNombreDesc").clear();
        }
    }

}
