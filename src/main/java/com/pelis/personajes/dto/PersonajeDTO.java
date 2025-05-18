package com.pelis.personajes.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonajeDTO {
    private String nombre;
    private String identificacion;
    private String imagenUrl;
    private String rol;
    private String descripcion;
}
