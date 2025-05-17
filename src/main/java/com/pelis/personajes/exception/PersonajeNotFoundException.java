package com.tuempresa.personajes.exception;

public class PersonajeNotFoundException extends RuntimeException {
    public PersonajeNotFoundException(String message) {
        super(message);
    }
}
