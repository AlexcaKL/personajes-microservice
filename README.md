# 🎬 Personajes Microservicio

Este microservicio desarrollado en Java 17 con Spring Boot permite gestionar personajes de una serie o película. 
Incluye operaciones CRUD, ordenamiento, uso de caché, manejo de excepciones, pruebas unitarias y seguridad con JWT.

---

## 🛠️ Tecnologías

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Cache
- Spring Security + JWT
- H2 (Base de datos en memoria)
- Lombok
- JUnit + Mockito

---

## 🚀 Cómo ejecutar el proyecto

1. Clonar el repositorio o descomprimir el proyecto

2. Compilar con Maven:

    mvn clean install

3. Ejecutar:

    mvn spring-boot:run

La aplicación correrá en: http://localhost:8080

---

## 🔐 Autenticación

Autenticación vía JWT.

Endpoint de login:

    POST /auth/login

Body JSON:

    {
      "username": "admin",
      "password": "1234"
    }

El resto de los endpoints requieren el header:

    Authorization: Bearer <tu-token>

---

## 📦 Endpoints principales

- POST    /auth/login — Obtener token JWT
- POST    /api/personajes — Crear personaje
- GET     /api/personajes — Obtener todos
- GET     /api/personajes/ordenados/asc — Ordenar por nombre ascendente
- GET     /api/personajes/ordenados/desc — Ordenar por nombre descendente
- GET     /api/personajes/ordenados/fecha-asc — Ordenar por fecha de creación ascendente
- GET     /api/personajes/ordenados/fecha-desc — Ordenar por fecha de creación descendente
- PUT     /api/personajes/{id} — Editar personaje
- DELETE  /api/personajes/{id} — Eliminar personaje
- POST    /admin/limpiar-cache — Limpiar caché (admin)

---

## 💾 Consola H2 (opcional)

URL: http://localhost:8080/h2-console  
JDBC URL: jdbc:h2:mem:personajesdb  
Usuario: sa  
Contraseña: (vacía)

---

## ✅ Pruebas unitarias

    mvn test

---