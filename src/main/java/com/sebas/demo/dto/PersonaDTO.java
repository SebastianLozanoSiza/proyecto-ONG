package com.sebas.demo.dto;

import lombok.Data;

@Data
public class PersonaDTO {
    
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    
}
