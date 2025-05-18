package com.pelis.personajes.exception;

public class PersonajeNotFoundException extends RuntimeException {
    public PersonajeNotFoundException(String message) {
        super(message);
    }
}
