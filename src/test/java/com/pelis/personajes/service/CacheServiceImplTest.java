package com.pelis.personajes.service;

import com.pelis.personajes.service.impl.CacheServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class CacheServiceImplTest {

    @Test
    void testLimpiarCachePersonajes() {
        CacheManager manager = mock(CacheManager.class);
        Cache mockCache = mock(Cache.class);

        Map<String, Cache> caches = new HashMap<>();
        when(manager.getCache("personajes")).thenReturn(mockCache);
        when(manager.getCache("personajesNombreAsc")).thenReturn(mockCache);
        when(manager.getCache("personajesNombreDesc")).thenReturn(mockCache);

        CacheServiceImpl cacheService = new CacheServiceImpl(manager);
        cacheService.limpiarCachePersonajes();

        verify(mockCache, times(3)).clear();
    }
}
